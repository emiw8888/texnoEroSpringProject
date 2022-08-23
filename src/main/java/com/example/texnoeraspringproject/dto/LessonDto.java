package com.example.texnoeraspringproject.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Builder
@Getter
public class LessonDto {
    private Long id;
    private String name;
    private BookDto book;
    private TeacherDto teacher;
    private Date createdAt;
}
