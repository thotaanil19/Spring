package com.springboot.jmscamelconsumer.camel;

import org.springframework.stereotype.Service;

import com.springboot.jmscamelconsumer.dto.Employee;

@Service
public class EmployeeService {

	public void processMessage(Employee emp) {
		System.out.println(emp);
	}
	
}
