package com.example.texnoeraspringproject.mapper;


import com.example.texnoeraspringproject.dao.entity.TeacherEntity;
import com.example.texnoeraspringproject.model.dto.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public abstract class TeacherMapper {
    public static TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    public abstract TeacherEntity mapToEntity(TeacherDto teacher);

    public abstract TeacherDto mapToDto(TeacherEntity teacher);
}
