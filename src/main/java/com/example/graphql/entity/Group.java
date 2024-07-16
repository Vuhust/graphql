package com.example.graphql.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;
    @Column(name = "'name'")
    private String name;
    @Column(name = "'desc''")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL , mappedBy = "group")
    @Fetch(FetchMode.JOIN)
    private Set<User> users = new HashSet<>();

}