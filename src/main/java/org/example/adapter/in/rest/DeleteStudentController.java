package org.example.adapter.in.rest;

import org.example.application.port.in.student.DeleteStudentCase;
import spark.Request;
import spark.Response;

import javax.inject.Inject;

public class DeleteStudentController {
    private final DeleteStudentCase deleteStudentCase;

    @Inject
    public DeleteStudentController(DeleteStudentCase deleteStudentCase) {
        this.deleteStudentCase = deleteStudentCase;
    }

    public String deleteStudent(Request request, Response response) {
        System.out.println("deleteStudent");
        Long id = Long.parseLong(request.params("id"));
        deleteStudentCase.delete(id);
        response.type("application/json");
        response.status(200);
        return "{\"message\":\"success\"}";
    }
}
