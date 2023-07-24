package com.guilherme.springmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.springmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User user = new User("1", "Maria Brown", "maria@gmail.com");
		User user1 = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = Arrays.asList(user, user1);
		return ResponseEntity.ok(list);
	}
}
