package com.example.petshop.exceptions;

public class OutOfPurchaseException extends Exception {
	/**
	 * serialid
	 */
	private static final long serialVersionUID = 1L;

	String message;

	public OutOfPurchaseException(String message) {
		super(message);
		this.message = message;
	}

	public OutOfPurchaseException() {
		super();
	}

}
