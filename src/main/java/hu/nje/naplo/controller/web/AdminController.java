package hu.nje.naplo.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admins")
public class AdminController {

    @GetMapping(path = "/subjects")
    public String subjects(Model model) {
        return "admin/subjects";
    }

    @PostMapping(path = "/subjects")
    public String subjectCreation(Model model) {
        return "redirect:admin/subjects";
    }
}
