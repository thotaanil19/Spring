package com.anil.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeService extends AbstractService {
	
	@Autowired 
	private AbstractService abstractService;
	
	public String method() {
		System.out.println("Start");
		//super.method();
		abstractService.method();
		System.out.println("End");
		return "Hi 2";
	}

}
