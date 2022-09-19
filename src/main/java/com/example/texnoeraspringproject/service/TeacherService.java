package com.example.texnoeraspringproject.service;

import com.example.texnoeraspringproject.model.dto.TeacherDto;
import com.example.texnoeraspringproject.mapper.TeacherMapper;
import com.example.texnoeraspringproject.dao.repository.LessonRepository;
import com.example.texnoeraspringproject.dao.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository, LessonRepository lessonRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    public void saveTeacher(TeacherDto teacherDto) {
        teacherRepository.save(TeacherMapper.INSTANCE.mapToEntity(teacherDto));
    }
}
