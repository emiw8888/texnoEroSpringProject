package com.example.texnoeraspringproject.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Getter
@Builder
@ApiModel("This is model of Author table")
public class AuthorDto {
    @ApiModelProperty("id of author")
    private Long id;

    @NotBlank(message = "full name can not be empty")
    @ApiModelProperty("full name of author")
    private String fullName;


    @ApiModelProperty("this is many to many relationship with book table")
    private List<Long> bookId;

    @ApiModelProperty("created time of author")
    private Date createdAt;
}
