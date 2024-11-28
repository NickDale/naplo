package hu.nje.naplo.controller.rest;

import hu.nje.naplo.repository.GradeRepository;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.util.Optional;

public class GradeRestController {
    private GradeRepository gradeService;


    @GetMapping
    private List<?> listGrades() {
        return gradeService.listGrades();
    }

    @GetMapping(path = "grades/{gradeId}")
    private Object findGradeById(@PathVariable @Positive final int gradeId) {
        return gradeService.findById(gradeId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private void createGrade() {
        //studentService.deleteStudentById(studentId);
    }

    @PatchMapping(path = "edit_grade/{gradeId}")
    private void updateGrade(@PathVariable @Positive final int GradeId) {
        //studentService.deleteStudentById(studentId);
    }

    @DeleteMapping(path = "/delete_grade/{gradeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable @Positive final int gradeId) throws InvalidAlgorithmParameterException {
        gradeService.deleteGradeById(gradeId);
    }
}
