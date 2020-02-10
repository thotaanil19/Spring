package com.springboot.mongodb.dao.morphia;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;
import com.springboot.mongodb.domain.Movie;

public class MovieMorphiaRepository extends BasicDAO<Movie, String> {
	
	public MovieMorphiaRepository(MongoClient mongo, Morphia morphia, String dbName) {	
        super(mongo,new Morphia(),dbName);
    }

}
