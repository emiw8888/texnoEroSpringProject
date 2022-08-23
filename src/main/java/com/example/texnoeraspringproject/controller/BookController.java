package com.example.texnoeraspringproject.controller;



import com.example.texnoeraspringproject.dto.BookDto;
import com.example.texnoeraspringproject.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@Api(description = "book controllerimiz")
@RestController
@RequestMapping("/v1/books")
public class BookController {//bookcontroller
    BookService bookService;//book service
    public BookController(BookService mainService) {
        this.bookService = mainService;
    }

    @ApiOperation("kitablari getiren api")
    @GetMapping
    public @ResponseBody List<BookDto> getBooks() throws SQLException {
        return bookService.getBooks();
    }
    @GetMapping("/{id}")
    public @ResponseBody
    BookDto getBookById(@PathVariable("id") Long id) throws SQLException {
        return bookService.getBookById(id);
    }
    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) throws SQLException {
        bookService.saveBook(bookDto);
    }
    @GetMapping("/exist/{id}")
    public boolean checkBook(@PathVariable("id") Long id){
        return bookService.checkBook(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
    @PutMapping
    public void updateBook(@RequestBody BookDto bookDto){
        bookService.editBookById(bookDto);
    }
//    @PostMapping("/add")
//    public void addToCart(@RequestBody BookDto booksDto){
//        bookService.addToCart(booksDto.getBookId());
//    }
//    @GetMapping("/buy")
//    public List<BookDto> buyBooks(){
//        List<BookDto> list = List.copyOf(mainService.buyBooks());
//        mainService.list.removeIf(x -> true);
//        return list;
//    }

}
