package hu.nje.naplo.controller.web.controller;

import hu.nje.naplo.entity.Grade;
import hu.nje.naplo.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @GetMapping
    public String grades(Model model) {
        List<Grade> grades = gradeService.findAllGrades();
        model.addAttribute("grades", grades);
        return "grades";
    }

    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
        @GetMapping("/add")
    public String addStudent(Model model) {
        return "admin/add_grade";
    }
}
