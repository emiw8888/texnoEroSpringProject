package com.example.texnoeraspringproject.controller;


import com.example.texnoeraspringproject.model.dto.BookDto;
import com.example.texnoeraspringproject.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(description = "this is book controller for control book table")
@RestController
@RequestMapping("/v1/books")
public class BookController {
    BookService bookService;

    public BookController(BookService mainService) {
        this.bookService = mainService;
    }

    @ApiOperation("api for getting all books")
    @GetMapping
    public @ResponseBody
    List<BookDto> getAllBooks() {
        return bookService.getBooks();
    }

    @ApiOperation("api for getting book by id")
    @GetMapping("/{id}")
    public @ResponseBody
    BookDto getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @ApiOperation("api for adding book")
    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookDto);
    }

    @ApiOperation("api for checking exist book or no")
    @GetMapping("/exist/{id}")
    public boolean checkBook(@PathVariable("id") Long id) {
        return bookService.checkBook(id);
    }

    @ApiOperation("api for deleting book")
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @ApiOperation("api for editing book")
    @PutMapping
    public void updateBook(@RequestBody BookDto bookDto) {
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
