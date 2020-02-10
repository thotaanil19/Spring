package com.springboot.blockchain.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.blockchain.domain.AppUser;

public interface UserRepository extends MongoRepository<AppUser, String> {

	AppUser findByUsername(String username);
	
}
