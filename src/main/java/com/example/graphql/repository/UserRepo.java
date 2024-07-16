package com.example.graphql.repository;

import com.example.graphql.entity.Book;
import com.example.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    <T>List<T> findAllByName(String username, Class<T> clazz);
}
