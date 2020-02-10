package com.springboot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.springboot.mongodb.domain.MongoDetails;

@SpringBootApplication
@EnableConfigurationProperties(MongoDetails.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
