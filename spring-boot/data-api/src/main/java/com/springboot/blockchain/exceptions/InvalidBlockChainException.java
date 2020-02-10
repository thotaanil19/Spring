package com.springboot.blockchain.exceptions;

public class InvalidBlockChainException extends RuntimeException {

	private static final long serialVersionUID = 9038524762093950306L;

	public InvalidBlockChainException() {
	}
	
	public InvalidBlockChainException(String message) {
		super(message);
	}
	

}
