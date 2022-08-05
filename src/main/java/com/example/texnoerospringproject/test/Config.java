package com.example.texnoerospringproject.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "com.example.texnoerospringproject.test")
public class Config {
    @Bean
    public Student student(){
        return new Student("murad",34);
    }

}
