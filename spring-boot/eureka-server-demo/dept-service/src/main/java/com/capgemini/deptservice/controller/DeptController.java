package com.capgemini.deptservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.deptservice.dto.Dept;

@RestController
public class DeptController {

	@GetMapping("/dept/{id}")
	public Dept get(@PathVariable("id") Integer id) {
		Dept dept = new Dept(id, "Dept"+id);
		//Dept dept = Dept.builder().id(id).name("Dept"+id).build();
		return dept;

	}
}
