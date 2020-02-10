package com.springboot.jmsproducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.jmsproducer.dto.Department;
import com.springboot.jmsproducer.service.DepartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;	
	
	@Test
	public void sendMessageTest() throws Exception {
		departmentService.sendMessage(new Department(1, "dept"));
	}
	

}
