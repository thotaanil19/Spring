package com.springboot.jmscamelconsumer.camel;

import javax.jms.ConnectionFactory;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.jmscamelconsumer.dto.Employee;

@Component
@Configuration
public class CamelRouteBuilder extends RouteBuilder {

	private static final Logger LOG = LoggerFactory.getLogger(CamelRouteBuilder.class);
	
	@Autowired
	private DepartmentService departmentService;

	 @Bean(name = "activemq")
	    public ActiveMQComponent createComponent(ConnectionFactory factory) {
	        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
	        activeMQComponent.setConnectionFactory(factory);
	        return activeMQComponent;
	    }	
	
	@Override
	public void configure() throws Exception {

		from("activemq:queue:employee-queue").log(LoggingLevel.DEBUG, LOG, "New emp message received").process(exchange -> {
			ObjectMapper mapper = new ObjectMapper();
			Employee emp = mapper.readValue(exchange.getMessage().getBody(String.class), Employee.class);
			exchange.getMessage().setBody(emp);
		}).to("bean:employeeService?method=processMessage").end();		
		
		//from("activemq:queue:dept-queue").log(LoggingLevel.DEBUG, LOG, "New dept message received").bean(departmentService).
		from("activemq:topic:dept-topic").log(LoggingLevel.DEBUG, LOG, "New dept message received").bean(departmentService)
		.end();

	}
}
