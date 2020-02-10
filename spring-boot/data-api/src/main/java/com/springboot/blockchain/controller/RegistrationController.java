package com.springboot.blockchain.controller;

import static com.springboot.blockchain.constants.SecurityConstants.AUTHORIZATION;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blockchain.domain.Block;
import com.springboot.blockchain.domain.Registration;
import com.springboot.blockchain.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping
	public ResponseEntity<Boolean> saveRegistration(@RequestBody Registration registration, @RequestHeader(AUTHORIZATION) String token) {
		
		Boolean registrationStatus = registrationService.saveRegistration(registration);
		return new ResponseEntity<Boolean>(registrationStatus, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Block>> getRegistrationHistory(@RequestHeader(AUTHORIZATION) String token) {
		
		List<Block> history = registrationService.getRegistrationHistory();
		return new ResponseEntity<List<Block>>(history, HttpStatus.OK);
		
	}

}
