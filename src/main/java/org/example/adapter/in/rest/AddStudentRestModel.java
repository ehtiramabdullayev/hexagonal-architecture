package org.example.adapter.in.rest;

import org.example.model.student.Student;

public class AddStudentRestModel {
    private String name;
    private int age;
    private String email;

    public AddStudentRestModel(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static AddStudentRestModel fromDomainModel(Student student){
        return new AddStudentRestModel(student.getName(), student.getAge(), student.getEmail());
    }

    public  Student toDomainModel(){
        return new Student(1L,this.name,this.age,this.email);
    }
}
