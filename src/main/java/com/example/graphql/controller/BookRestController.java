package com.example.graphql.controller;

import com.example.graphql.entity.*;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import com.example.graphql.repository.GroupRepo;
import com.example.graphql.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    @GetMapping("/testnative")
    @ResponseStatus(HttpStatus.OK)
    public Object updateBasook() {

        List<bookInterface> book2 = bookRepository.nativeQuery("1");
//        book2.getFirst().setId(1);
        return book2
        ;
    }


    @GetMapping("/testadd")
    @ResponseStatus(HttpStatus.OK)
    public Object updassteBasook() {
        bookRepository.save(new Book());

//        return bookRepository.getAllByAuthor("a");
        return null;
    }

    private final UserRepo userRepo;
    private final GroupRepo groupRepo;

    @GetMapping("/getAllUser")
    @ResponseStatus(HttpStatus.OK)
    public Object getallu() {
        return userRepo.findAll();


    }


    @GetMapping("/getAllGroup")
    @ResponseStatus(HttpStatus.OK)
    public Object getallg() {
        List<Group> groups = groupRepo.findAll();
        return groups;
//        return groupRepo.findAll();


    }

    @GetMapping("/findByName")
    @ResponseStatus(HttpStatus.OK)
    public Object findbn() {
        List<Group> groups = groupRepo.findAllByDescriptionContaining("haha");
        return groups;
//        return groupRepo.findAll();


    }

    @GetMapping("/findu")
    @ResponseStatus(HttpStatus.OK)
    public Object findu() {

//        return userRepo.findAllByName("Doe", UX.class);
//        return groupRepo.findAll();

        return userRepo.findAll();

    }
}