package com.springboot.jmscamelproducer.camel;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.jmscamelproducer.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	private ProducerTemplate  producerTemplate;

	public void sendMessage(Employee emp) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(emp);		
		producerTemplate.sendBody("activemq:employee-queue", message);
	}	
	  
}
