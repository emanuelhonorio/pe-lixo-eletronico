package com.emanuelhonorio.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.emanuelhonorio.error.exceptions.ResourceAlreadyExistsException;
import com.emanuelhonorio.error.exceptions.ResourceNotFoundException;
import com.emanuelhonorio.error.exceptions.ResourceOwnerException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<?> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
		ErroResponse err = new ErroResponse(HttpStatus.CONFLICT.value(), ex.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ErroResponse err = new ErroResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(ResourceOwnerException.class)
	public ResponseEntity<?> ResourceOwnerException(ResourceOwnerException ex) {
		ErroResponse err = new ErroResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	@ExceptionHandler(MultipartException.class)
	public ResponseEntity<?> handleMultipartException(MultipartException ex) {
		ErroResponse err = new ErroResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}
}
