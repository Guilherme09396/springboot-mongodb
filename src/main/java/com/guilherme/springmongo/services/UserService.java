package com.guilherme.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.springmongo.domain.User;
import com.guilherme.springmongo.repository.UserRepository;
import com.guilherme.springmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
