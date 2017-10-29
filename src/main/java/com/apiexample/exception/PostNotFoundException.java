package com.apiexample.exception;

public class PostNotFoundException extends RuntimeException {

	private Long resourceId;

	public PostNotFoundException(Long resourceId, String message) {
		super(message);
		this.resourceId = resourceId;
	}

	public PostNotFoundException() {
	}

}
