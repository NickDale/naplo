package hu.nje.naplo.controller.rest;

import hu.nje.naplo.service.StudentService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api/students", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService studentService;


    @GetMapping
    private List<?> listStudents() {
        return studentService.listStudents();
    }

    @GetMapping(path = "/{studentId}")
    private Object findStudentById(@PathVariable @Positive final int studentId) {
        return studentService.findById(studentId);
    }

    @DeleteMapping(path = "/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable @Positive final int studentId) throws InvalidAlgorithmParameterException {
        studentService.deleteStudentById(studentId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private void createStudent() {
        //studentService.deleteStudentById(studentId);
    }

    @PatchMapping(path = "/{studentId}")
    private void updateStudent(@PathVariable @Positive final int studentId) {
        //studentService.deleteStudentById(studentId);
    }


}
