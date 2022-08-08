package com.example.texnoeraspringproject.mapper;


import com.example.texnoeraspringproject.dao.BooksEntity;
import com.example.texnoeraspringproject.dto.BooksDto;
import org.springframework.stereotype.Component;

@Component
public class BooksMapper {
    public BooksEntity mapToEntity(BooksDto books){
        return new BooksEntity(null,books.getBookName(),
                books.getBookTopic(),
                books.getCreatedAt());
    }
    public BooksDto mapToDto(BooksEntity books){
        return new BooksDto(null,books.getBookName(),
                books.getBookTopic(),
                books.getCreatedAt());
    }
}
