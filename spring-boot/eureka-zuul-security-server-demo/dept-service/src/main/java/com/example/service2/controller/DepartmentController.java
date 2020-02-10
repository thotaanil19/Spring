package com.example.service2.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service2.domain.Department;

@RestController
@RequestMapping("/v1/dept")
public class DepartmentController {

	@GetMapping("/{id}")
	public Department get(@Valid @PathVariable Integer id) {
		return new Department(id, "Obama", "+1-1234567890", "USA", 9999999);
	}

	
}
