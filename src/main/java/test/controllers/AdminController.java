package test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.dto.FormDto;
import test.repositories.AccountsRepository;
import test.services.FormService;

import java.sql.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts/{id}")
public class AdminController {
    private final AccountsRepository accountsRepository;

    @GetMapping
    public String getAdmin(Authentication authentication, @PathVariable String id, Model model) {
        if (authentication != null) {
            model.addAttribute("accounts", accountsRepository.findAll());
            model.addAttribute("account_id", id);
            model.addAttribute("account_fio", accountsRepository.getAccountById(Long.valueOf(id)).getFIO());
            return "admin";
        } else return "redirect:/error/401";
    }
}
