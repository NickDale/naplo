package hu.nje.naplo.controller.rest;

import hu.nje.naplo.entity.Student;
import hu.nje.naplo.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/students")
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    private List<Student> listStudents() {
        return studentService.listStudents();
    }

    @GetMapping(path = "/{studentId}")
    private Student findStudentById(@PathVariable @Positive final int studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Student createStudent( @RequestBody final Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping(path = "/{studentId}")
    private Student updateStudent(@PathVariable @Positive final int studentId,
                                  @Valid @RequestBody final Student student) {
        return studentService.modifyStudent(studentId, student);
    }

    @PatchMapping(path = "/{studentId}")
    private Student partiallyUpdate(@PathVariable @Positive final int studentId, @RequestBody Map<String, Object> updates) {
        return studentService.modifyStudent(studentId, updates);
    }

    @DeleteMapping(path = "/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable @Positive final int studentId) {
        studentService.deleteStudentById(studentId);
    }

}
