package com.springboot.blockchain.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.blockchain.domain.JwtToken;

@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken,String> {
}
