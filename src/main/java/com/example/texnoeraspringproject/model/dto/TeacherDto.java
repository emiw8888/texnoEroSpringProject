package com.example.texnoeraspringproject.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.sql.Date;


@Builder
@Getter
@ApiModel("This is model of teacher table")
public class TeacherDto {
    @ApiModelProperty("this id of teacher")
    private Long id;

    @NotBlank(message = "full name of teacher can not be empty")
    @ApiModelProperty("this is full name of teacher")
    private String fullName;

    @NotBlank(message = "salary of teacher can not be empty")
    @ApiModelProperty("this is salary of teacher")
    private BigDecimal salary;

    @ApiModelProperty("this is one to one relationship with lesson table")
    private LessonDto lesson;

    @ApiModelProperty("this is created time of teacher")
    private Date createdAt;

    public TeacherDto() {
    }

    public TeacherDto(Long id, String fullName, BigDecimal salary, LessonDto lesson, Date createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.salary = salary;
        this.lesson = lesson;
        this.createdAt = createdAt;
    }
}
