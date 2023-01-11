package com.grupo5.reto2.user;

public class UserRequest {
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
