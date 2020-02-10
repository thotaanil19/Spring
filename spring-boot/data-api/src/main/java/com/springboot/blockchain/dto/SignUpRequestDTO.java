package com.springboot.blockchain.dto;

import lombok.Data;

@Data
public class SignUpRequestDTO {
	private String name;
	private String email;
	private String username;
	private String password;
	private String role;
}
