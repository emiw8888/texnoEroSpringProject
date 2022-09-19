package com.example.texnoeraspringproject.mapper;

import com.example.texnoeraspringproject.dao.entity.LessonEntity;
import com.example.texnoeraspringproject.model.dto.LessonDto;;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public abstract class LessonMapper {
    public static LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);


    public abstract LessonEntity mapToEntity(LessonDto lessonDto);

    public abstract LessonDto mapToDto(LessonEntity lessonEntity);
}
