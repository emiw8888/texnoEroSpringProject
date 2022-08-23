package com.example.texnoeraspringproject.controller;

import com.example.texnoeraspringproject.dto.AuthorDto;
import com.example.texnoeraspringproject.service.AuthorService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Test")
@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping
    public void saveAuthor(@RequestBody AuthorDto authorDto){
        authorService.saveAuthor(authorDto);
    }
}
