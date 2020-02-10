package com.capgemini.deptservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptServiceApplication.class, args);
	}

}
