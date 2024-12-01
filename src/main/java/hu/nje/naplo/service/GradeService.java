package hu.nje.naplo.service;

import hu.nje.naplo.entity.Grade;
import hu.nje.naplo.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository repository;

    public List<Grade> findAllGrades() {
        return this.repository.findAll();
    }
}
