package com.guilherme.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.springmongo.domain.Post;
import com.guilherme.springmongo.repository.PostRepository;
import com.guilherme.springmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post post = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		return post;
	}
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitleContaining(text);
	}
}
