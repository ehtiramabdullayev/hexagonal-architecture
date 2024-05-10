package org.example.bootstrap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.adapter.in.rest.AddStudentController;
import org.example.adapter.in.rest.DeleteStudentController;
import org.example.adapter.in.rest.GetAllStudentsController;

import static spark.Spark.before;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static final int MAIN_PORT = 5556;

    public static void main(String[] args) {
        port(MAIN_PORT);
        before((request, response) -> response.type("application/json"));
        initRoutes();
    }

    public static void initRoutes() {
        Injector injector = Guice.createInjector(new ApplicationBinding());
        AddStudentController addStudentController = injector.getInstance(AddStudentController.class);
        GetAllStudentsController getAllStudentsController = injector.getInstance(GetAllStudentsController.class);
        DeleteStudentController deleteStudentController = injector.getInstance(DeleteStudentController.class);
        get("/hello", (req, res) -> "Hello Code Nomads");
        post("/api/students", addStudentController::addStudent);
        get("/api/students", getAllStudentsController::getAllStudents);
        delete("/api/students/:id", deleteStudentController::deleteStudent);

    }
}