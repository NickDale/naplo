package hu.nje.naplo.service;

import hu.nje.naplo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<?> listStudents() {
        return studentRepository.findAll();
    }

    public Object findById(int studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Diák nem található az adott ID-val: " + studentId));
    }

    public void deleteStudentById(final int studentId) throws InvalidAlgorithmParameterException {
        if (!studentRepository.existsById(studentId)) {
            throw new InvalidAlgorithmParameterException("Diák nem található az adott ID-val: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }
}
