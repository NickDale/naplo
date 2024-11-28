package hu.nje.naplo.controller.rest;


import hu.nje.naplo.repository.GradeRepository;
import hu.nje.naplo.repository.SubjectRepository;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;

public class SubjectRestController {

    private SubjectRepository subjectService;


    @GetMapping
    private List<?> listSubjects() {
        return subjectService.listSubjects();
    }

    @GetMapping(path = "subjects/{subjectId}")
    private Object findSubjectById(@PathVariable @Positive final int subjectId) {
        return subjectService.findById(subjectId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private void createSubject() {
        //studentService.deleteStudentById(studentId);
    }

    @PatchMapping(path = "/edit_subject/{subjectId}")
    private void updateSubject(@PathVariable @Positive final int subjectId) {
        //studentService.deleteStudentById(studentId);
    }

    @DeleteMapping(path = "/delete_subject/{subjectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable @Positive final int subjectId) throws InvalidAlgorithmParameterException {
        subjectService.deleteStudentById(subjectId);
    }
}
