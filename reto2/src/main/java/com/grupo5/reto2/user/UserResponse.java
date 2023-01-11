package com.grupo5.reto2.user;

public class UserResponse {
	private String dni;
	private String accessToken;
	
	public UserResponse() {}

	public UserResponse(String dni, String accessToken) {
		super();
		this.dni = dni;
		this.accessToken = accessToken;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "UserResponse [dni=" + dni + ", accessToken=" + accessToken + "]";
	}
	
}
