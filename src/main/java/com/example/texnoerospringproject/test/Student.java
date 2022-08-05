package com.example.texnoerospringproject.test;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private int gpa;

    Student(String name,int gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }
}
