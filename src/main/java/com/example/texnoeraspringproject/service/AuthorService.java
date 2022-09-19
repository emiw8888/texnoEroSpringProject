package com.example.texnoeraspringproject.service;

import com.example.texnoeraspringproject.client.TexnoEraSpringClient;
import com.example.texnoeraspringproject.model.dto.AuthorDto;
import com.example.texnoeraspringproject.mapper.AuthorMapper;
import com.example.texnoeraspringproject.dao.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthorService {
    AuthorRepository authorRepository;
    TexnoEraSpringClient client;

    public AuthorService(AuthorRepository authorRepository,TexnoEraSpringClient client) {
        this.authorRepository = authorRepository;
        this.client = client;
    }

    public List<AuthorDto> getAllAuthors() {
        log.info("getAllAuthors.started");
        log.info("getBooks client start");
        client.getBooks().forEach(x -> System.out.println(x.getName()));
        return authorRepository.findAll()
                .stream()
                .map(AuthorMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    public void saveAuthor(AuthorDto authorDto) {
        log.info("saveAuthor.starting");
        authorRepository.save(AuthorMapper.INSTANCE.mapToEntity(authorDto));
        log.info("new author saved by id: " + authorRepository
                .findByFullName(authorDto.getFullName()).getId());
    }
}
