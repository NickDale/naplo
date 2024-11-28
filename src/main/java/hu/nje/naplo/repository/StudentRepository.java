package hu.nje.naplo.repository;

import hu.nje.naplo.entity.Student;
import hu.nje.naplo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    static List<Student> findByClassName(String className) {
        return null;
    }

    List<Student> findByMen(Boolean isMale);
    Optional<Student> findByStudentName(String studentName);

}
