package com.example.texnoeraspringproject.controller;


import com.example.texnoeraspringproject.model.dto.TeacherDto;
import com.example.texnoeraspringproject.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teachers")
@Api(description = "this is teacher controller for control teacher table")
public class TeacherController {
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ApiOperation("api for getting all teachers")
    @GetMapping
    public List<TeacherDto> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @ApiOperation("api for adding teacher")
    @PostMapping
    public void addTeacher(@RequestBody TeacherDto teacherDto){
        teacherService.saveTeacher(teacherDto);
    }
}
