package hu.nje.naplo.controller.web;

import hu.nje.naplo.entity.Subject;
import hu.nje.naplo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectService;

    @GetMapping("/subjects")
    public String getSubjects(Model model) {
        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        return "subjects";  // A Thymeleaf sablon neve
    }
    @GetMapping("/add")
    public String showAddSubjectForm(Model model) {
//        model.addAttribute("categories", subjectService.getCategories());
        return "admin/add_subject";
    }

    @PostMapping("/add")
    public String addSubject(@RequestParam String subject_name, @RequestParam String category) {
//        subjectService.addSubject(subject_name, category);
        return "redirect:/admin/list";
    }
}