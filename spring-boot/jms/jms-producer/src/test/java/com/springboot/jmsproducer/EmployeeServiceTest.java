package com.springboot.jmsproducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.jmsproducer.dto.Employee;
import com.springboot.jmsproducer.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService employeeService;	
	
	@Test
	public void sendMessageTest() throws Exception {
		employeeService.sendMessage(new Employee(1, "Anil"));
	}
	

}
