package com.example.texnoeraspringproject.service;


import com.example.texnoeraspringproject.client.WeatherClient;
import com.example.texnoeraspringproject.dao.entity.ArchivedBookEntity;
import com.example.texnoeraspringproject.dao.entity.BookEntity;
import com.example.texnoeraspringproject.dao.repository.ArchivedBookRepository;
import com.example.texnoeraspringproject.model.client.ForecastModel;
import com.example.texnoeraspringproject.model.dto.BookDto;
import com.example.texnoeraspringproject.mapper.BookMapper;
import com.example.texnoeraspringproject.dao.repository.BookRepository;
import com.example.texnoeraspringproject.model.exception.UserNotFoundException;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {
    BookRepository repository;
    ArchivedBookRepository archivedBookRepository;
    WeatherClient weatherClient;
    String applicationKey;

    public BookService(BookRepository repository,
                       ArchivedBookRepository archivedBookRepository,
                       WeatherClient weatherClient,
                       @Value("${api-key}") String applicationKey) {
        this.repository = repository;
        this.archivedBookRepository = archivedBookRepository;
        this.weatherClient = weatherClient;
        this.applicationKey = applicationKey;
    }

    public BookService(BookRepository bookRepository) {
        repository = bookRepository;
    }

    public List<BookDto> getBooks() {
        log.info("method getBooks: starting");
        return repository.findAll().stream().map(
                        BookMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    public int sum(int a, int b) {
        return a + b;
    }


    public BookDto getBookById(Long id) {
        BookEntity bookEntity = repository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("no such book with this id");
        });
        return BookMapper.INSTANCE.mapToDto(bookEntity);
    }

    public void saveBook(BookDto bookDto) {
        repository.save(BookMapper.INSTANCE.mapToEntity(bookDto));
    }

    public Boolean checkBook(Long id) {
        return repository.existsById(id);
    }

    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    public void editBookById(BookDto bookDto) {
        log.info("method editBookById: starting");
//        BookEntity bookEntity = repository.findById(bookDto.getId()).orElseThrow();
//        bookEntity.setId(bookDto.getId());
        saveBookToArchive(repository.findById(bookDto.getId()).orElseThrow());
        log.info("editBookById is continue");
        repository.save(BookMapper.INSTANCE.mapToEntity(bookDto));
        log.info("book updated");
    }

    @Async
    public void saveBookToArchive(BookEntity bookEntity) {
        log.info("saveBookToArchive start with id:" + bookEntity.getId());
        ArchivedBookEntity archivedBook = ArchivedBookEntity.of(bookEntity);
        archivedBookRepository.save(archivedBook);
        log.info("saveBookToArchive end with id:" + bookEntity.getId());
    }

    public List<BookDto> buyBooks() {
        return null;
    }

    public void addToCart(Long id) {
    }
}
