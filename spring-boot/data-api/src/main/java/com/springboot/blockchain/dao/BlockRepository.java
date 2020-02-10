package com.springboot.blockchain.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.blockchain.domain.Block;

public interface BlockRepository extends MongoRepository<Block, String> {

	Optional<List<Block>> findAllByOrderByTimeStampDesc();
			
	
	
}
