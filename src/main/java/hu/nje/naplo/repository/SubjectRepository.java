package hu.nje.naplo.repository;

import hu.nje.naplo.entity.Subject;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
//    List<Subject> findByCategory(String category);
//
//    void addSubject(String subjectName, String category);
//
//    Object getCategories();
//
//    void deleteStudentById(@Positive int studentId);
//
//    List<?> listSubjects();
//    boolean existsByName(String name);
//    boolean existsByName(String name);
}
