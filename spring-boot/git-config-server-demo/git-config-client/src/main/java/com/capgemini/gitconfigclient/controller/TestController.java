package com.capgemini.gitconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
	
	@Value("${name}")
	private String name;
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/test")
	public String get () {
		System.out.println(name);
		System.out.println(message);
		return name + " " + message;
	}

}
