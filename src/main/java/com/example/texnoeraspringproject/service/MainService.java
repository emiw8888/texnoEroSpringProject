package com.example.texnoeraspringproject.service;
import com.example.texnoeraspringproject.dto.BooksDto;

import java.sql.SQLException;
import java.util.List;

public interface MainService {
    List<BooksDto> getBooks() throws SQLException;
    BooksDto getBookById(Long id) throws SQLException;
    void saveBook(BooksDto bookDto) throws SQLException;
    Boolean checkBook(Long id);
    void deleteBookById(Long id);
    int editBookById(BooksDto booksDto);
}
