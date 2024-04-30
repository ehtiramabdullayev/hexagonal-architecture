package org.example.application.port.out;

import org.example.model.student.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);
    Optional<Student> findById(Student productId);
    List<Student> findAll();
    void deleteById(Long id);

}
