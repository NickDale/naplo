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
        //TODO: implement!
        return null;
    }

    public Object findById(int studentId) {
         //TODO: implement!
        return null;
    }

    public void deleteStudentById(final int studentId) {
       //TODO: implement!
        throw InvalidAlgorithmParameterException();
    }
}
