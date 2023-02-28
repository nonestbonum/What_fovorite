package test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.dto.FormDto;
import test.repositories.AccountsRepository;
import test.services.FormService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/{id}")
public class FormController {
    private final AccountsRepository accountsRepository;
    private final FormService formService;

    @PostMapping("/form")
    public String postForm(@PathVariable String id,
                           @Valid FormDto form, BindingResult bindingResult, Model model) { // здесь изменила, проверяю форму на валидность, а не передаю отдельно каждое значение
        if (bindingResult.hasErrors()) {
            model.addAttribute("formDto", new FormDto());
            model.addAttribute("account_id",id);
            model.addAttribute("account_fio",accountsRepository.getAccountById(Long.valueOf(id)).getFIO());
            model.addAttribute("fail", "Введены некорректные данные");
            return "form";
        } else {
            formService.saveForm(Long.valueOf(id), form);
            return "thanks";
        }
    }

    @GetMapping
    public String getForm(@PathVariable String id, Model model,
                          Authentication authentication) {
        if (authentication != null) {
            model.addAttribute("formDto", new FormDto());
            model.addAttribute("account_id", id);
            model.addAttribute("account_fio", accountsRepository.getAccountById(Long.valueOf(id)).getFIO());
            return "form";
        } else return "redirect:/error/401";
    }
}
