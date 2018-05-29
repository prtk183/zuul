package com.szuul.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.szuul.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	@Query
	Optional<Object> findById(String id);


	}

