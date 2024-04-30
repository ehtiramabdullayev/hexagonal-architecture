package org.example.adapter.in.rest;

import org.example.adapter.common.JsonParser;
import org.example.application.port.in.student.GetAllStudentsCase;
import org.example.model.student.Student;
import spark.Request;
import spark.Response;

import javax.inject.Inject;
import java.util.List;

public class GetAllStudentsController {
    private final GetAllStudentsCase getAllStudentsCase;
    private final JsonParser jsonParser;

    @Inject
    public GetAllStudentsController(GetAllStudentsCase getAllStudentsCase, JsonParser jsonParser) {
        this.getAllStudentsCase = getAllStudentsCase;
        this.jsonParser = jsonParser;
    }

    public String getAllStudents(Request request, Response response) {
        List<Student> allStudents = getAllStudentsCase.getAllStudents();
        System.out.println(allStudents);
        response.type("application/json");
        return jsonParser.toJsonPOJO(allStudents);
    }

}
