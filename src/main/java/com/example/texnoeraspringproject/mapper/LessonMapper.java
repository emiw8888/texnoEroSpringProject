package com.example.texnoeraspringproject.mapper;

import com.example.texnoeraspringproject.dao.entity.LessonEntity;
import com.example.texnoeraspringproject.dto.LessonDto;

public class LessonMapper {
    public static LessonEntity mapToEntity(LessonDto lessonDto){
        return LessonEntity.builder()
                .id(lessonDto.getId())
                .book(BookMapper.mapToEntity(lessonDto.getBook()))
                .createdAt(lessonDto.getCreatedAt())
                .name(lessonDto.getName())
                .build();
    }
    public static LessonDto mapToDto(LessonEntity lessonEntity){
        return LessonDto.builder()
                .book(BookMapper.mapToDto(lessonEntity.getBook()))
                .createdAt(lessonEntity.getCreatedAt())
                .name(lessonEntity.getName())
                .build();
    }
    public static LessonDto mapToDtoWithoutBook(LessonEntity lessonEntity){
        return LessonDto.builder()
                .createdAt(lessonEntity.getCreatedAt())
                .name(lessonEntity.getName())
                .build();
    }
}
