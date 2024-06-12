package com.example.graphql.controller;

import com.example.graphql.entity.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookRestController {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @GetMapping("/1")
    public Collection<Book> findBooks() {
        return bookRepository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(
            @PathVariable("id") final String id, @RequestBody final Book book) {
        return book;
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public Object updateBasook() {
        return bookRepository.getAllByAuthor("a");
    }


    @GetMapping("/testadd")
    @ResponseStatus(HttpStatus.OK)
    public Object updassteBasook() {


        return bookRepository.getAllByAuthor("a");
    }

}