package com.emanuelhonorio.error.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public static final String DEFAUL_MESSAGE = "Resource already exists";
	
	public ResourceAlreadyExistsException() {
		super(DEFAUL_MESSAGE);
	}
	
	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}
