package com.example.texnoeraspringproject.service

import com.example.texnoeraspringproject.dao.entity.BookEntity
import com.example.texnoeraspringproject.dao.repository.BookRepository
import com.example.texnoeraspringproject.mapper.BookMapper
import com.example.texnoeraspringproject.model.exception.UserNotFoundException
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

import java.time.LocalDateTime

class BookServiceSpec extends Specification {
    BookRepository repository

    private BookService bookService

    private random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build()
    void setup(){
        repository = Mock()
        bookService = new BookService(repository)
    }

    def "dd"() {
        when:
        def result = bookService.sum(2,3)
        then:
        result == 5
    }
    def "testGetBookById"(){
        given:
        def id = 1L
        def bookEntity = random.nextObject(BookEntity)
        when:
        def result = bookService.getBookById(id)
        then:
        1 * repository.findById(id) >> Optional.of(bookEntity)

        result == BookMapper.INSTANCE.mapToDto(bookEntity)
    }

    def "testGetBookByIdException"(){
        when:
        bookService.getBookById(45L)
        then:
        repository.findById(45L) >> Optional.empty()
        def result = thrown(UserNotFoundException)
        result.message == "no such book with this id"
    }
}
