package org.example.adapter.out.persistance.inmemory;

import org.example.application.port.out.StudentRepository;
import org.example.model.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryStudentRepository implements StudentRepository {
    private static final List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Optional<Student> findById(Student productId) {
        return students.stream().filter(student -> student.getId().equals(productId.getId())).findFirst();
    }

    @Override
    public List<Student> findAll() {
        return students;
    }
    @Override
    public void deleteById(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
