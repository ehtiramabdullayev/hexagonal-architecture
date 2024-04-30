package org.example.application.service;

import org.example.application.port.in.student.GetAllStudentsCase;
import org.example.application.port.out.StudentRepository;
import org.example.model.student.Student;

import javax.inject.Inject;
import java.util.List;

public class GetAllStudentsService implements GetAllStudentsCase {
    private final StudentRepository studentRepository;

    @Inject
    public GetAllStudentsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
