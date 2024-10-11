package hu.nje.naplo.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(path = {"/", "/home"})
    public String homePage(Model model) {
        return "home";
    }
}
