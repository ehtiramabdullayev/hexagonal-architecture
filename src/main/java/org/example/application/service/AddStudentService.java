package org.example.application.service;

import org.example.application.port.in.student.AddStudentCase;
import org.example.application.port.out.StudentRepository;
import org.example.model.student.Student;

import javax.inject.Inject;
import java.util.Objects;

public class AddStudentService implements AddStudentCase {
    private final StudentRepository studentRepository;

    @Inject
    public AddStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        Objects.requireNonNull(student, "student must not be null");
        return studentRepository.save(student);
    }
}
