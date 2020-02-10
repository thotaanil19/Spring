package com.springboot.springsoapconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.country.dto.wsdl.GetCountryResponse;
import com.springboot.employee.dto.wsdl.GetEmployeeResponse;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private CountryClient CountryClient;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	
	@RequestMapping("/country")
	public GetCountryResponse getCountry() {
		GetCountryResponse response = CountryClient.getCountry("India");
		return response;
	}
	@RequestMapping("/employee")
	public GetEmployeeResponse getEmployee() {
		GetEmployeeResponse response = employeeClient.getEmployee(1);
		return response;
	}
}
