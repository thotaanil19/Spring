package com.capgemini.springbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBatchMongo2xmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchMongo2xmlApplication.class, args);
	}

}
