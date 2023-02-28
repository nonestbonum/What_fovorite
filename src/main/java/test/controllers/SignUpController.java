package test.controllers;

import test.dto.SignUpForm;
import test.repositories.AccountsRepository;
import test.services.SignUpService;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getSignUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @PostMapping
    public String signUp(@Valid SignUpForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("signUpForm", new SignUpForm());
            model.addAttribute("fail", "Введены некорректные данные");
            return "signUp";
        } else if (signUpService.existsAccountByEmailAndPassword(form)) {
            model.addAttribute("fail", "Такой пользователь уже существует");
            return "signUp";
        } else {
            signUpService.signUp(form);
            model.addAttribute("massage", "Вам на почту была отправлена ссылка для активации аккаунта");
            return "mailWasSend";
        }
    }
    @GetMapping("/mailWasSend")
    public String mailWasSend(){
        return "mailWasSend";
    }


    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code, Model model) {
        boolean isActivated = signUpService.activateUser(code);
        if (!isActivated) {
            model.addAttribute("massage", "Вам на почту была отправлена ссылка для активации аккаунта");
            return "redirect:/mailWasSend";
        } else
            return "redirect:/signIn";
    }
}






