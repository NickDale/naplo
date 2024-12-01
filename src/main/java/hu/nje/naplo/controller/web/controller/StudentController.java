package hu.nje.naplo.controller.web.controller;

import hu.nje.naplo.entity.Student;
import hu.nje.naplo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    @GetMapping
    public String getSubjects(Model model) {
        final List<Student> students = studentService.listStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/add_student")
    public String addStudent(Model model) {
        final List<Student> students = studentService.listStudents();
        model.addAttribute("students", students);
        return "admin/add_student";
    }
}