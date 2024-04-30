package org.example.bootstrap;

import com.google.inject.AbstractModule;

import org.example.adapter.out.persistance.inmemory.InMemoryStudentRepository;
import org.example.application.port.in.student.AddStudentCase;
import org.example.application.port.out.StudentRepository;
import org.example.application.service.AddStudentService;

public class ApplicationBinding extends AbstractModule {
    @Override
    protected void configure() {
        bind(AddStudentCase.class).to(AddStudentService.class);
        bind(StudentRepository.class).to(InMemoryStudentRepository.class);
    }
}
