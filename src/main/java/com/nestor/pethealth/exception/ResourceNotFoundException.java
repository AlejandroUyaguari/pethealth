package com.nestor.pethealth.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1500068604217000887L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
