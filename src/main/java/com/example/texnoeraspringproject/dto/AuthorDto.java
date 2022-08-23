package com.example.texnoeraspringproject.dto;

import com.example.texnoeraspringproject.dao.entity.BookEntity;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@Getter
@Builder
public class AuthorDto {
    private Long id;
    private String fullName;
    private List<BookEntity> book;
    private Date createdAt;
}
