package com.example.texnoeraspringproject.dao.repository;

import com.example.texnoeraspringproject.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    Optional<BookEntity> findById(Long id);
    @Override
    List<BookEntity> findAll();

    BookEntity findByName(String name);

}
