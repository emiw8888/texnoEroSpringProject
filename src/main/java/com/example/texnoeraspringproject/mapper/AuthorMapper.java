package com.example.texnoeraspringproject.mapper;


import com.example.texnoeraspringproject.dao.entity.AuthorEntity;
import com.example.texnoeraspringproject.dto.AuthorDto;


public class AuthorMapper {
    public static AuthorEntity mapToEntity(AuthorDto authorDto){
        return AuthorEntity.builder()
                .id(authorDto.getId())
                .fullName(authorDto.getFullName())
                .createdAt(authorDto.getCreatedAt())
                .build();
    }
    public static AuthorDto mapToDto(AuthorEntity authorEntity){
        return AuthorDto.builder()
                .fullName(authorEntity.getFullName())
                .createdAt(authorEntity.getCreatedAt())
                .build();
    }
}
