package com.example.texnoeraspringproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class  BooksDto {
    private Long bookId;
    private String bookName;
    private String bookTopic;
    private Date createdAt;

}
