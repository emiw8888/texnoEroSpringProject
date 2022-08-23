package com.example.texnoeraspringproject.service;

import com.example.texnoeraspringproject.dto.AuthorDto;
import com.example.texnoeraspringproject.mapper.AuthorMapper;
import com.example.texnoeraspringproject.dao.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<AuthorDto> getAllAuthors() {
        log.info("getAllAuthors.started");
        return authorRepository.findAll()
                .stream()
                .map(AuthorMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void saveAuthor(AuthorDto authorDto) {
        log.info("saveAuthor.starting");
        authorRepository.save(AuthorMapper.mapToEntity(authorDto));
        log.info("new author saved by id: " + authorRepository
                .findByFullName(authorDto.getFullName()).getId());
    }
}
