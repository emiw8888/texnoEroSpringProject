package com.example.texnoerospringproject.test;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = context.getBean("person",Person.class);
        System.out.println(person.student.getName());
        System.out.println(person.student.getGpa());
    }
}
