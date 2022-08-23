package com.example.texnoeraspringproject.controller;


import com.example.texnoeraspringproject.dto.LessonDto;
import com.example.texnoeraspringproject.dto.TeacherDto;
import com.example.texnoeraspringproject.service.LessonService;
import com.example.texnoeraspringproject.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/lessons")

public class LessonController {
    LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<LessonDto> getTeachers(){
        return lessonService.getAllLessons();
    }
    @PostMapping
    public void saveTeacher(@RequestBody LessonDto lessonDto){
        lessonService.saveLesson(lessonDto);
    }
}
