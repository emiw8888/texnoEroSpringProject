package com.example.texnoeraspringproject.service;


import com.example.texnoeraspringproject.dao.BooksEntity;
import com.example.texnoeraspringproject.dto.BooksDto;
import com.example.texnoeraspringproject.mapper.BooksMapper;
import com.example.texnoeraspringproject.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("!local")
public class MainServiceImpl implements MainService {
    @Autowired
    BooksRepository repository;
    @Autowired
    BooksMapper booksMapper;

    @Override
    public List<BooksDto> getBooks() throws SQLException {
        return repository.findAll().stream().map(
                        x -> booksMapper.mapToDto(x))
                .collect(Collectors.toList());
    }

    @Override
    public BooksDto getBookById(Long id) throws SQLException {
        return booksMapper.mapToDto(repository.findByBookId(id));
    }

    @Override
    public void saveBook(BooksDto bookDto) throws SQLException {
        repository.save(booksMapper.mapToEntity(bookDto));
    }

    @Override
    public Boolean checkBook(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public int editBookById(BooksDto booksDto) {
        int updatedRows = 0;
        BooksEntity booksEntity = repository.findByBookId(booksDto.getBookId());
        if (!booksDto.getBookName().equals(booksEntity.getBookName())) {
            updatedRows += repository.updateBookNameByBookId(booksDto.getBookName(), booksDto.getBookId());
        } else if (!booksDto.getBookTopic().equals(booksEntity.getBookTopic())) {
            updatedRows += repository.updateBookTopicByBookId(booksDto.getBookTopic(), booksDto.getBookId());
        } else if (!booksDto.getCreatedAt().equals(booksEntity.getCreatedAt())) {
            updatedRows += repository.updateCreatedAtByBookId(booksDto.getCreatedAt(), booksDto.getBookId());
        }
        return updatedRows;
    }
}
