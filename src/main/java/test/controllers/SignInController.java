package test.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.dto.SignInForm;
import test.models.Account;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/signIn")
public class SignInController {
    private Long id;


    @GetMapping
    public String getSignIn(Model model) {
        model.addAttribute("signInForm", new SignInForm());
        return "signIn";
    }

    @PostMapping
    public String postSignIn(Authentication authentication, Model model, @AuthenticationPrincipal Account account) {
        if (authentication != null && account.isActivated()) {
            id = account.getId();
            return "redirect:/" + id;
        } else {
            model.addAttribute("signInForm", new SignInForm());
            model.addAttribute("fail", "Wrong email or password");
            return "signIn";
        }
    }
}
