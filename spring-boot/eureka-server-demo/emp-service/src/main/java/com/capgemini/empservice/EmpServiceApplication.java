package com.capgemini.empservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpServiceApplication.class, args);
	}

	
}
