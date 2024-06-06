package com.example.graphql.controller;


import com.example.graphql.bookDetails.*;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
class BookController {

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

}