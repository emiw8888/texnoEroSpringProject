package com.example.texnoeraspringproject.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Builder
@Getter
@ApiModel("This is model of lesson table")
public class LessonDto {
    @ApiModelProperty("this is id of lesson")
    private Long id;

    @NotBlank(message = "name of lesson can not be empty")
    @ApiModelProperty("this is name of lesson")
    private String name;

    @ApiModelProperty("this is many to one relationship with book table")
    private BookDto book;

    @ApiModelProperty("this is created time of lesson")
    private Date createdAt;

    public LessonDto() {
    }

    public LessonDto(Long id, String name, BookDto book, Date createdAt) {
        this.id = id;
        this.name = name;
        this.book = book;
        this.createdAt = createdAt;
    }
}
