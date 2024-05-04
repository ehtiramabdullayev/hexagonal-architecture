package org.example.application.service;

import org.example.application.port.in.student.DeleteStudentCase;
import org.example.application.port.out.StudentRepository;

import javax.inject.Inject;

public class DeleteStudentService implements DeleteStudentCase {
    private final StudentRepository studentRepository;

    @Inject
    public DeleteStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
