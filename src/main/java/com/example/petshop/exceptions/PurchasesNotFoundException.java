package com.example.petshop.exceptions;

public class PurchasesNotFoundException extends Exception {
	/**
	 * serialid
	 */
	private static final long serialVersionUID = 1L;

	String message;

	public PurchasesNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public PurchasesNotFoundException() {
		super();
	}

}
