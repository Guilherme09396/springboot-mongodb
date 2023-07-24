package com.guilherme.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.springmongo.domain.User;
import com.guilherme.springmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public Void delete(String id) {
		findById(id);
		repo.deleteById(id);
		return null;
	}
	
	public User fromDto(UserDTO obj) {
		User user = new User(obj.getId(), obj.getNome(), obj.getEmail());
		return user;
	}
	
}
