package com.example.texnoerospringproject.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {


    Student student;
    String surname;

    public Person(Student s) {
        this.student = s;
    }

    public Person() {
    }
@Autowired
    public void setStudent(Student student) {
        this.student = student;
    }
}
