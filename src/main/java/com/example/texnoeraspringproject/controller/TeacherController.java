package com.example.texnoeraspringproject.controller;


import com.example.texnoeraspringproject.dto.TeacherDto;
import com.example.texnoeraspringproject.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teachers")
public class TeacherController {
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDto> getTeachers(){
        return teacherService.getAllTeachers();
    }
    @PostMapping
    public void saveTeacher(@RequestBody TeacherDto teacherDto){
        teacherService.saveTeacher(teacherDto);
    }
}
