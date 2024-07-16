package com.example.graphql.repository;

import com.example.graphql.entity.Book;
import com.example.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
