package com.example.texnoeraspringproject.mapper;


import com.example.texnoeraspringproject.dao.entity.TeacherEntity;
import com.example.texnoeraspringproject.dto.TeacherDto;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public static TeacherEntity mapToEntity(TeacherDto teacher){
        return TeacherEntity.builder()
                .fullName(teacher.getFullName())
                .lesson(LessonMapper.mapToEntity(teacher.getLesson()))
                .salary(teacher.getSalary())
                .createdAt(teacher.getCreatedAt())
                .build();
    }
    public static TeacherDto mapToDto(TeacherEntity teacher){
        return TeacherDto.builder()
                .createdAt(teacher.getCreatedAt())
                .fullName(teacher.getFullName())
                .lesson(LessonMapper.mapToDto(teacher.getLesson()))
                .salary(teacher.getSalary())
                .build();
    }
    public static TeacherDto mapToDtoWithoutLesson(TeacherEntity teacher){
        return TeacherDto.builder()
                .createdAt(teacher.getCreatedAt())
                .fullName(teacher.getFullName())
                .salary(teacher.getSalary())
                .build();
    }
}
