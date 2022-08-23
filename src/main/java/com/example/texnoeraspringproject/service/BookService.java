package com.example.texnoeraspringproject.service;


import com.example.texnoeraspringproject.dao.entity.BookEntity;
import com.example.texnoeraspringproject.dto.BookDto;
import com.example.texnoeraspringproject.mapper.BookMapper;
import com.example.texnoeraspringproject.dao.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository repository;



    public List<BookDto> getBooks() {
        return repository.findAll().stream().map(
                        BookMapper::mapToDto)
                .collect(Collectors.toList());
    }


    public BookDto getBookById(Long id){
        return BookMapper.mapToDto(repository.findById(id).orElseThrow());
    }

    public void saveBook(BookDto bookDto) {
        repository.save(BookMapper.mapToEntity(bookDto));
    }

    public Boolean checkBook(Long id) {
        return repository.existsById(id);
    }

    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    public void editBookById(BookDto bookDto) {
        repository.save(BookMapper.mapToEntity(bookDto));
    }


    public List<BookDto> buyBooks() {
        return null;
    }

    public void addToCart(Long id) {
    }
}
