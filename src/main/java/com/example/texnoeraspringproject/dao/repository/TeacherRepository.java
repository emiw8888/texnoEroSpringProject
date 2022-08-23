package com.example.texnoeraspringproject.dao.repository;

import com.example.texnoeraspringproject.dao.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {

}
