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
@RequestMapping("/{id}")
public class FormController {
    private final AccountsRepository accountsRepository;
    private final FormService formService;

    @PostMapping("/form")
    public String postForm(@PathVariable String id,
                         @RequestParam("favDish") String favDish,
                         @RequestParam("favColor") String favColor,
                         @RequestParam("favSong") String favSong,
                         @RequestParam("favDate") Date favDate,
                         @RequestParam("favNum") int favNum,
                         Model model) {
        if (favDish == null || favColor == null || favSong == null || favDate == null){
            model.addAttribute("fail","Не должно быть пустых значений");
            return "form";
        }
        else {
            FormDto formDto = new FormDto(favDish, favColor, favSong, favDate, favNum);
            formService.saveForm(Long.valueOf(id), formDto);
            return "thanks";
        }

    }

    @GetMapping
    public String getForm(@PathVariable String id, Model model,
                          Authentication authentication) {
        if (authentication != null) {
            model.addAttribute("account_id", id);
            model.addAttribute("account_fio", accountsRepository.getAccountById(Long.valueOf(id)).getFIO());
            return "form";
        } else return "redirect:/error/401";
    }
}
