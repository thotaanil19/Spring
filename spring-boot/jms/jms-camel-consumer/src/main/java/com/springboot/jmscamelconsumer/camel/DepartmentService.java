package com.springboot.jmscamelconsumer.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.jmscamelconsumer.dto.Department;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Department dept = mapper.readValue(exchange.getMessage().getBody(String.class), Department.class);
		log.info("Dept:", dept);
	}

}
