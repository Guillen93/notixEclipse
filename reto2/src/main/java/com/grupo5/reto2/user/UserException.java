package com.grupo5.reto2.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.CONFLICT, reason = "Couldn`t create the user")
public class UserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UserException(String errorMessage) {
		super (errorMessage);
	}
}
