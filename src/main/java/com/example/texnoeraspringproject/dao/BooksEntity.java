package com.example.texnoeraspringproject.dao;

import lombok.*;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "books")
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private String bookTopic;
    private Date createdAt;


}
