package com.springboot.springsoapconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

	/*
	 * @Bean public Jaxb2Marshaller marshaller() { Jaxb2Marshaller marshaller = new
	 * Jaxb2Marshaller(); marshaller.setContextPath(""); return marshaller; }
	 */

	@Bean
	public CountryClient countryClient() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.springboot.country.dto.wsdl");

		CountryClient client = new CountryClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public EmployeeClient employeeClient() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.springboot.employee.dto.wsdl");

		EmployeeClient client = new EmployeeClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}