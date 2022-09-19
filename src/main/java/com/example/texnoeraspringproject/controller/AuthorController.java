package com.example.texnoeraspringproject.controller;

import com.example.texnoeraspringproject.model.dto.AuthorDto;
import com.example.texnoeraspringproject.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(description = "this is author controller for control author table")
@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ApiOperation("api for getting all authors")
    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @ApiOperation("api for adding author")
    @PostMapping
    public void addAuthor(@RequestBody @Valid AuthorDto authorDto){
        authorService.saveAuthor(authorDto);
    }
}
