package com.capgemini.empservice;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfig {
	
	@LoadBalanced
	@Bean
	public RestTemplate buildRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
		
	}

}
