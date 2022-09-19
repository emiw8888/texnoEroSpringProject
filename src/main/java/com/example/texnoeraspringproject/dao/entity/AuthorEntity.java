package com.example.texnoeraspringproject.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "authors_books",joinColumns = {
            @JoinColumn(name = "author_id",referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "book_id",referencedColumnName = "id")
    })
    private List<BookEntity> book;

    @CreationTimestamp
    private Date createdAt;

    public AuthorEntity(Long id, String fullName, List<BookEntity> book, Date createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.book = book;
        this.createdAt = createdAt;
    }

    public AuthorEntity() {
    }
}
