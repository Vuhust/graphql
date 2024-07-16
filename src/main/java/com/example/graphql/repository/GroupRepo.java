package com.example.graphql.repository;

import com.example.graphql.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepo extends JpaRepository<Group, Long> {
    List<Group> findByName(String name);


    List<Group> findByDescription(String description);

    <T> List<T> findAllByDescription(String description, Class<T> clazz);
    @Query(value = "from Group g join fetch g.users as u")
    List<Group> findAllByDescriptionContaining(String description);
}
