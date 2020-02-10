package com.springboot.blockchain.dao.morphia;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.springboot.blockchain.domain.Block;
import com.springboot.blockchain.dto.MongoDetails;

@Repository
public class BlockMorphiaRepository extends BasicDAO<Block, String> {
	
	@Autowired
	public BlockMorphiaRepository(MongoClient mongo, MongoDetails mongoDetails) {	
        super(mongo,new Morphia(),mongoDetails.getDatabase());
    }

}
