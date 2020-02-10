package com.springboot.jmscamelproducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.jmscamelproducer.camel.DepartmentService;
import com.springboot.jmscamelproducer.dto.Department;

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
