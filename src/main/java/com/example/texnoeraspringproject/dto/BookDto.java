package com.example.texnoeraspringproject.dto;

import com.example.texnoeraspringproject.dao.entity.AuthorEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


@Data
@Builder
@ApiModel("this is book model")
public class BookDto {
    private Long id;
    @ApiModelProperty("this book name")
    private String name;
    private BigDecimal price;
    private List<AuthorDto> author;
    private Date createdAt;
}
