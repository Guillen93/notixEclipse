package com.grupo5.reto2.user;

import java.util.List;

import com.grupo5.reto2.role.Role;

public class UserServiceModel {

	private String dni;
	private boolean isEnabled;
	private List<Role> roles ;

	public UserServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserServiceModel(String dni, boolean isEnabled, List<Role> roles) {
		super();
		this.dni = dni;
		this.isEnabled = isEnabled;
		this.roles = roles;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserServiceModel [dni=" + dni + ", isEnabled=" + isEnabled + ", roles=" + roles + "]";
	}

}
