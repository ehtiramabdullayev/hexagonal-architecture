package org.example.application.port.in.student;

import org.example.model.student.Student;

import java.util.List;

public interface GetAllStudentsCase {
    List<Student> getAllStudents();
}
