package hu.nje.naplo.service;

import hu.nje.naplo.entity.Student;
import hu.nje.naplo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    public Student findById(final int studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Diák nem található az adott ID-val: " + studentId));
    }

    public void deleteStudentById(final int studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Diák nem található az adott ID-val: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student modifyStudent(int studentId, final Student student) {
        boolean existsById = studentRepository.existsById(studentId);
        if (!existsById) {
            throw new RuntimeException("Diák nem található az adott ID-val: " + studentId);
        }
        student.setId(studentId);
        return studentRepository.save(student);
    }

    public Student modifyStudent(final int studentId, final Map<String, Object> updates) {
        Student student = this.findById(studentId);

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Student.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, student, value);
            }
        });

        return studentRepository.save(student);
    }
}
