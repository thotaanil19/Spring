package com.springboot.springsoapconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.springboot.employee.dto.wsdl.GetEmployeeRequest;
import com.springboot.employee.dto.wsdl.GetEmployeeResponse;


public class EmployeeClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(EmployeeClient.class);

	public GetEmployeeResponse getEmployee(Integer id) {

		GetEmployeeRequest request = new GetEmployeeRequest();
		request.setId(id);

		log.info("Requesting location for " + request);
		
		GetEmployeeResponse response = (GetEmployeeResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8081/ws/employees", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetEmployeeRequest"));

		return response;
	}

}
