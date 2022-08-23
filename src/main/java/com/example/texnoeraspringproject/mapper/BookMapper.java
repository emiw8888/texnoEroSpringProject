package com.example.texnoeraspringproject.mapper;

import com.example.texnoeraspringproject.dao.entity.BookEntity;
import com.example.texnoeraspringproject.dto.BookDto;
import java.util.stream.Collectors;


public class BookMapper {
    public static BookEntity mapToEntity(BookDto books){//book
        return BookEntity.builder()
                .id(books.getId())
                .author(books.getAuthor().stream()
                        .map(AuthorMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .name(books.getName())
                .createdAt(books.getCreatedAt())
                .price(books.getPrice())
                .build();
    }
    public static BookDto mapToDto(BookEntity books){
        return BookDto.builder()
                .author(books.getAuthor().stream()
                        .map(AuthorMapper::mapToDto)
                        .collect(Collectors.toList()))
                .name(books.getName())
                .createdAt(books.getCreatedAt())
                .price(books.getPrice())
                .build();
    }
}
