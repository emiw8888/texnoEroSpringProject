package com.example.texnoeraspringproject.dao.repository;

import com.example.texnoeraspringproject.dao.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity,Long> {
    LessonEntity findByName(String name);

}
