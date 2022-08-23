package com.example.texnoeraspringproject.dao.repository;

import com.example.texnoeraspringproject.dao.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
    AuthorEntity findByFullName(String fullName);

}
