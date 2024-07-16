package com.example.graphql.repository;

import com.example.graphql.entity.Book;
import com.example.graphql.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group, Long> {
}
