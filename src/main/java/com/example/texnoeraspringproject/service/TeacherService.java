package com.example.texnoeraspringproject.service;

import com.example.texnoeraspringproject.dao.entity.LessonEntity;
import com.example.texnoeraspringproject.dao.entity.TeacherEntity;
import com.example.texnoeraspringproject.dto.TeacherDto;
import com.example.texnoeraspringproject.mapper.TeacherMapper;
import com.example.texnoeraspringproject.dao.repository.LessonRepository;
import com.example.texnoeraspringproject.dao.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    LessonRepository lessonRepository;

    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void saveTeacher(TeacherDto teacherDto) {
        LessonEntity lessonEntity = lessonRepository.findByName(teacherDto.getLesson().getName());
        TeacherEntity teacherEntity = TeacherMapper.mapToEntity(teacherDto);
        teacherEntity.setLesson(lessonEntity);
        teacherRepository.save(teacherEntity);
    }
}
