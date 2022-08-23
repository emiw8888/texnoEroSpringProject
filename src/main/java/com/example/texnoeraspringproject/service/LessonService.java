package com.example.texnoeraspringproject.service;

import com.example.texnoeraspringproject.dao.entity.BookEntity;
import com.example.texnoeraspringproject.dao.entity.LessonEntity;
import com.example.texnoeraspringproject.dto.LessonDto;
import com.example.texnoeraspringproject.mapper.LessonMapper;
import com.example.texnoeraspringproject.dao.repository.BookRepository;
import com.example.texnoeraspringproject.dao.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService  {
    public LessonService(LessonRepository lessonRepository, BookRepository booksRepository) {
        this.lessonRepository = lessonRepository;
        this.booksRepository = booksRepository;
    }

    LessonRepository lessonRepository;
    BookRepository booksRepository;

    public List<LessonDto> getAllLessons() {
        return lessonRepository.findAll()
                .stream()
                .map(LessonMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void saveLesson(LessonDto lessonDto) {
        lessonRepository.save(LessonMapper.mapToEntity(lessonDto));
    }
}
