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

    @GetMapping(path = "/students")
    public String students(Model model) {
        return "admin/students";
    }

    @PostMapping(path = "/students")
    public String sudentCreation(Model model) {
        return "redirect:admin/students";
    }

    @GetMapping(path = "/grades")
    public String grades(Model model) {
        return "admin/grades";
    }

    @PostMapping(path = "/grades")
    public String gradesCreation(Model model) {
        return "redirect:admin/grades";
    }
}
