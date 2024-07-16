package com.example.graphql.repository;

import com.example.graphql.entity.Book;
import com.example.graphql.entity.Book2;
import com.example.graphql.entity.bookInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book2 getAllByAuthor(String author);

    <T> T findById(Long id, Class<T> type);

    @Query(nativeQuery = true ,value = "SELECT id FROM book")
    List<bookInterface> nativeQuery(String id);

}