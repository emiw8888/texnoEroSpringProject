package com.example.texnoeraspringproject.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Date;


@Builder
@Getter
public class TeacherDto {
    private String fullName;
    private BigDecimal salary;
    private LessonDto lesson;
    private Date createdAt;
}
