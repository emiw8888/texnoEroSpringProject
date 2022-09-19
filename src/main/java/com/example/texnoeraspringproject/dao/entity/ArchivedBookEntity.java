package com.example.texnoeraspringproject.dao.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "books_archive")
public class ArchivedBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public static ArchivedBookEntity of(BookEntity book){
        return ArchivedBookEntity.builder()
                .id(book.getId())
                .createdAt(book.getCreatedAt())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ArchivedBookEntity that = (ArchivedBookEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
