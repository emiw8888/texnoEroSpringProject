package com.example.texnoeraspringproject.scheduler;


import com.example.texnoeraspringproject.model.dto.BookDto;
import com.example.texnoeraspringproject.service.BookService;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BookScheduler {
    BookService bookService;
    public BookScheduler(BookService bookService) {
        this.bookService = bookService;
    }

    @Scheduled(fixedRateString = "PT2M")
    @SchedulerLock(name = "update created at of book",
    lockAtLeastFor = "PT2M",lockAtMostFor = "PT5M")
    public void updateCreatedAtOfBook(){
        List<BookDto> books = bookService.getBooks();
        books.forEach(x-> {
            x.setCreatedAt(LocalDateTime.now());
            bookService.saveBook(x);
        });

    }

    @Scheduled(fixedRateString = "PT2H")
    @SchedulerLock(name = "print all names of books",
            lockAtLeastFor = "PT3M",lockAtMostFor = "PT4M")
    public void printAllBookNames(){
        List<BookDto> books = bookService.getBooks();
        books.forEach(x-> System.out.println(x.getName()));
    }

    @Scheduled(cron = "0 0 9 * * ?")
    @SchedulerLock(name = "print welcome message",
            lockAtLeastFor = "PT1M",lockAtMostFor = "PT2M")
    public void printWelcomeMessage(){
        System.out.println("Welcome to the job! Have nice day!");
    }

    @Scheduled(cron = "0 19 16 27 * ?")
    @SchedulerLock(name = "print salary message",
            lockAtLeastFor = "PT1M",lockAtMostFor = "PT2M")
    public void printSalaryMessage(){
        System.out.println("check your card. salaries are added");
    }

    @Scheduled(cron = "0 0/30 19-22 * * ?")
    @SchedulerLock(name = "print welcome message",
            lockAtLeastFor = "PT1M",lockAtMostFor = "PT2M")
    public void printRestTime(){
        System.out.println("you can have break");
    }

}
