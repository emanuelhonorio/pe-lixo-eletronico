package com.emanuelhonorio.error.exceptions;

public class ResourceOwnerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public static final String DEFAUL_MESSAGE = "user is not the owner of this resource";
	
	public ResourceOwnerException() {
		super(DEFAUL_MESSAGE);
	}
	
	public ResourceOwnerException(String message) {
		super(message);
	}
}