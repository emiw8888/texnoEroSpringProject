package com.example.texnoeraspringproject.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "authors_books",joinColumns = {
            @JoinColumn(name = "book_id",referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "author_id",referencedColumnName = "id")
    })
    private List<AuthorEntity> author;

    @CreationTimestamp
    private Date createdAt;
}
