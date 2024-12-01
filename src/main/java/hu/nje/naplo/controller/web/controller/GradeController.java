package hu.nje.naplo.controller.web.controller;

import hu.nje.naplo.entity.Grade;
import hu.nje.naplo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Integer id) {
        Optional<Grade> grade = gradeRepository.findById(id);
        return grade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Integer id, @RequestBody Grade gradeDetails) {
        return gradeRepository.findById(id).map(grade -> {
            grade.setValue(gradeDetails.getValue());
            grade.setType(gradeDetails.getType());
            grade.setCreationDate(gradeDetails.getCreationDate());
            grade.setStudent(gradeDetails.getStudent());
            grade.setSubject(gradeDetails.getSubject());
            return ResponseEntity.ok(gradeRepository.save(grade));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Integer id) {
        if (gradeRepository.existsById(id)) {
            gradeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
