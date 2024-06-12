package com.example.graphql.repository;

import com.example.graphql.entity.Book;
import com.example.graphql.entity.Book2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book2 getAllByAuthor(String author);

    <T> T findById(Long id, Class<T> type);

}