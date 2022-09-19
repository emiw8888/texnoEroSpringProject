package com.example.texnoeraspringproject.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.concurrent.Future;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private BigDecimal salary;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "lesson_id")
    private LessonEntity lesson;
    @CreationTimestamp
    private Date createdAt;

}
