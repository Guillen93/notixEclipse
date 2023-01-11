package com.grupo5.reto2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Item already exists")
public class ConflictException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConflictException(String errorMessage) {
		super(errorMessage);
	}
	
}
