package com.example.graphql;

import com.example.graphql.entity.Group;
import com.example.graphql.entity.User;
import com.example.graphql.repository.GroupRepo;
import com.example.graphql.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GraphqlApplication.class, args);
		UserRepo userRepo = context.getBean(UserRepo.class);
		GroupRepo groupRepo = context.getBean(GroupRepo.class);

		Group g1 = groupRepo.save(new Group(1L, "group1","haha",null));

		Group g2 = groupRepo.save(new Group(2L, "group2","haha",null));

		Group g3 = groupRepo.save(new Group(3L, "group3","haha",null));
		User u1 = userRepo.save(new User(1L, "Doe", "john@doe.com",g1));
		User u2 = userRepo.save(new User(2L, "Doe", "john@doe.com", g2));
		User u3 = userRepo.save(new User(3L, "Doe", "john@doe.com", g3));
		Set<User> ulist = new HashSet<>();
		ulist.add(u1);
		ulist.add(u2);
		ulist.add(u3);

		groupRepo.save(new Group(3L, "group2","haha",ulist));
	}

}
