package com.emanuelhonorio.error.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public static final String DEFAUL_MESSAGE = "Resource not found";
	
	public ResourceNotFoundException() {
		super(DEFAUL_MESSAGE);
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}