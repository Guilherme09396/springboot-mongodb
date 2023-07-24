package com.guilherme.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guilherme.springmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
