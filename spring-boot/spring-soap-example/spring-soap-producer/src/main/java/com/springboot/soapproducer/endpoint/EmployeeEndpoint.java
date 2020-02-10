package com.springboot.soapproducer.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.springboot.countries.dto.GetCountryResponse;
import com.springboot.employee.GetEmployeeRequest;
import com.springboot.employee.GetEmployeeResponse;
import com.springboot.soapproducer.repository.EmployeeRepository;

@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeEndpoint(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		response.setEmployee(employeeRepository.findEmployee(request.getId()));
		return response;
	}
}