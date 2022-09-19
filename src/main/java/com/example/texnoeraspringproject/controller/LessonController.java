package com.example.texnoeraspringproject.controller;


import com.example.texnoeraspringproject.model.dto.LessonDto;
import com.example.texnoeraspringproject.service.LessonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/lessons")
@Api(description = "this is lesson controller for control lesson table")
public class LessonController {
    LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @ApiOperation("api for getting all lessons")
    @GetMapping
    public List<LessonDto> getAllLessons(){
        return lessonService.getAllLessons();
    }

    @ApiOperation("api for adding lesson")
    @PostMapping
    public void addLesson(@RequestBody LessonDto lessonDto){
        lessonService.saveLesson(lessonDto);
    }
}
