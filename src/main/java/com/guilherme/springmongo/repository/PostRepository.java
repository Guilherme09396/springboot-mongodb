package com.guilherme.springmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guilherme.springmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	List<Post> findByTitleContaining(String text);
}
