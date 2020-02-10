package com.example.service1.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service1.domain.Employee;

@RestController
@RequestMapping("/v1/emp")
public class EmployeeController {

	@GetMapping("/{id}")
	public Employee getEmployee(@Valid @PathVariable Integer id) {
		return new Employee(id, "Obama", "+1-1234567890", "USA", 9999999.99D);
	}

	@GetMapping()
	public Employee getEmployee2() {
		return new Employee(1, "Obama", "+1-1234567890", "USA", 9999999.99D);
	}
	
}
