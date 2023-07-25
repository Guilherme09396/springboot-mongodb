package com.guilherme.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guilherme.springmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
