package com.grupo5.reto2.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
	@NotNull()
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]")
	private String dni;
	private String password;
	
	public UserRequest() {}
	
	public UserRequest(String dni, String password) {
		super();
		this.dni = dni;
		this.password = password;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserRequest [dni=" + dni + ", password=" + password + "]";
	}
	
}
