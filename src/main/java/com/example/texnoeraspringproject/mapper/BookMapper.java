package com.example.texnoeraspringproject.mapper;

import com.example.texnoeraspringproject.dao.entity.BookEntity;
import com.example.texnoeraspringproject.model.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public abstract class BookMapper {
    public static BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

//    @Mapping(target = "createdAt",source = "createdAt",ignore = true)
    public abstract BookEntity mapToEntity(BookDto book);

    public abstract BookDto mapToDto(BookEntity book);
}
