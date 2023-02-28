package test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StartPageController {

    @GetMapping()
    public String getPage() {
        return "startPage";
    }
}
