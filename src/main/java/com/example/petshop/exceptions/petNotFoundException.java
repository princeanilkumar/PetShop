package com.example.petshop.exceptions;

public class petNotFoundException extends Exception {

	

	/**
	 * serialid
	 */
	private static final long serialVersionUID = 1L;
	
	String message;

	public petNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	public petNotFoundException() {
		super();
	}
	
	

}
