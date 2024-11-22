package hu.nje.naplo.repository;

import hu.nje.naplo.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    List<Grade> findByStudent_StudentName(String studentName);
    List<Grade> findBySubject_Name(String subjectName);
    List<Grade> findByCreationDateAfter(Instant date);


}
