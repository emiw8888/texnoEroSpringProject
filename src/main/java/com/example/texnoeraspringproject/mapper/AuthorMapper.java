package com.example.texnoeraspringproject.mapper;


import com.example.texnoeraspringproject.dao.entity.AuthorEntity;
import com.example.texnoeraspringproject.model.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public abstract class AuthorMapper {
    public static AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

//    @Mapping(target = "id",source = "id")
    public abstract AuthorEntity mapToEntity(AuthorDto authorDto);

    public abstract  AuthorDto mapToDto(AuthorEntity authorEntity);
}
