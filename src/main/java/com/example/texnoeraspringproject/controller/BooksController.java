package com.example.texnoeraspringproject.controller;



import com.example.texnoeraspringproject.dto.BooksDto;
import com.example.texnoeraspringproject.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BooksController {
    MainService mainService;
    public BooksController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public @ResponseBody List<BooksDto> getBooks() throws SQLException {
        return mainService.getBooks();
    }
    @GetMapping("/{id}")
    public @ResponseBody BooksDto getBookById(@PathVariable("id") Long id) throws SQLException {
        return mainService.getBookById(id);
    }
    @PostMapping
    public void saveBook(@RequestBody BooksDto booksDto) throws SQLException {
        mainService.saveBook(booksDto);
    }
    @GetMapping("/exist/{id}")
    public boolean checkBook(@PathVariable("id") Long id){
        return mainService.checkBook(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        mainService.deleteBookById(id);
    }
    @PutMapping
    public int editBookById(@RequestBody BooksDto booksDto){
        return mainService.editBookById(booksDto);
    }

}
