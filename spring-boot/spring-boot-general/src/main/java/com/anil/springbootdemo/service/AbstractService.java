package com.anil.springbootdemo.service;

import org.springframework.stereotype.Component;

@Component("abstractService")
public abstract class AbstractService {
	
	public String method() {
		System.out.println("Super Method");
		return "Hi 1";
	}

}
