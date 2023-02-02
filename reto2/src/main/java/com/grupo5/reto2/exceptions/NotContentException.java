package com.grupo5.reto2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Item not found")
public class NotContentException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotContentException(String errorMessage) {
		super(errorMessage);
	}

}
