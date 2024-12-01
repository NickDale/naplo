package hu.nje.naplo.controller.web.controller;

import hu.nje.naplo.entity.Subject;
import hu.nje.naplo.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectRepository subjectService;

    @GetMapping
    public String getSubjects(Model model) {
        final List<Subject> subjects = subjectService.findAll(Sort.by(Sort.Direction.ASC, "category"));
        model.addAttribute("subjects", subjects);
        return "subjects";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/add")
    public String addStudent(Model model) {
        return "admin/add_subject";
    }

}
