package com.apiexample.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.apiexample.model.api.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlingController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(PostNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(PostNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("NOT FOUND");
		response.setErrorMessage(ex.getMessage());
		logger.debug("Not found", ex);

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> genericException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("PAUSED");
		response.setErrorMessage("Service paused, try again later");
		logger.error("Review this exception , type:" + ex.getClass(), ex);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<ExceptionResponse> resourceAccessException(ResourceAccessException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("ERROR EXTERN");
		response.setErrorMessage("The extern resource is not available");
		logger.error("Error to connect to extern api", ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ExceptionResponse> methodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("VALIDATION");
		response.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
}