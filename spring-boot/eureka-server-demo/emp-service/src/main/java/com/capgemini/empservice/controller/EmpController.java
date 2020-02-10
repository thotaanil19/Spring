package com.capgemini.empservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.empservice.dto.Dept;
import com.capgemini.empservice.dto.Emp;

@RestController
public class EmpController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/emp/{id}")
	public Emp get(@PathVariable("id") Integer id) {
		Emp emp = new Emp();
		emp.setId(id);
		emp.setName("Emp" + id);
		Dept dept = restTemplate.getForObject("http://dept-service/dept/" + (id * 100), Dept.class);
		emp.setDept(dept);
		return emp;
	}

}
