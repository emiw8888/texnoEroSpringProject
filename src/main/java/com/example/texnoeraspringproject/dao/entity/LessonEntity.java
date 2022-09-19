package com.example.texnoeraspringproject.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "lessons")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private BookEntity book;
    @CreationTimestamp
    private Date createdAt;
}
