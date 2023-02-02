package com.grupo5.reto2.user;

import java.util.Set;

import com.grupo5.reto2.role.Role;

public class UserResponse {
	private String dni;
	private String accessToken;
	private Set<Role> roles;

	public UserResponse() {
	}

	public UserResponse(String dni, String accessToken, Set<Role> set) {
		super();
		this.dni = dni;
		this.accessToken = accessToken;
		this.roles = set;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserResponse [dni=" + dni + ", accessToken=" + accessToken + "]";
	}

}
