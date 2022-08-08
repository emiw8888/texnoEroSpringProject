package com.example.texnoeraspringproject.repository;

import com.example.texnoeraspringproject.dao.BooksEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface BooksRepository extends CrudRepository<BooksEntity,Long>, JpaSpecificationExecutor<BooksEntity> {

    @Override
    List<BooksEntity> findAll();

    BooksEntity findByBookId(Long bookId);

    @Transactional
    @Modifying
    @Query("update BooksEntity b set b.bookName = ?1 where b.bookId = ?2")
    int updateBookNameByBookId(String bookName, Long bookId);

    @Transactional
    @Modifying
    @Query("update BooksEntity b set b.bookTopic = ?1 where b.bookId = ?2")
    int updateBookTopicByBookId(String bookTopic, Long bookId);

    @Transactional
    @Modifying
    @Query("update BooksEntity b set b.createdAt = ?1 where b.bookId = ?2")
    int updateCreatedAtByBookId(Date createdAt, Long bookId);



}
