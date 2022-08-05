package com.example.texnoerospringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TexnoEroSpringProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TexnoEroSpringProjectApplication.class, args);
        System.out.println(run.getBeanDefinitionCount());
    }

}
