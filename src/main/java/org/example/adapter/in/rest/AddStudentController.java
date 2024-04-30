package org.example.adapter.in.rest;

import org.example.adapter.common.JsonParser;
import org.example.application.port.in.student.AddStudentCase;
import org.example.model.student.Student;
import spark.Request;
import spark.Response;

import javax.inject.Inject;

public class AddStudentController {

    private final AddStudentCase addStudentCase;
    private final JsonParser jsonParser;

    @Inject
    public AddStudentController(AddStudentCase addStudentCase, JsonParser jsonParser) {
        this.addStudentCase = addStudentCase;
        this.jsonParser = jsonParser;
    }


    public String addStudent(Request request, Response response) {
        AddStudentRestModel studentRequest = jsonParser.fromJSonToPOJO(request.body(), AddStudentRestModel.class);
        Student student = addStudentCase.addStudent(studentRequest.toDomainModel());
        AddStudentRestModel addStudentRestModel = AddStudentRestModel.fromDomainModel(student);
        response.type("application/json");
        return jsonParser.toJsonPOJO(addStudentRestModel);
    }
}