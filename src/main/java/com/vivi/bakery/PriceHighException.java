package com.vivi.bakery;

public class PriceHighException extends RuntimeException {
	
	private String message;
	public PriceHighException(String message) {
		super(message);
	}

}
