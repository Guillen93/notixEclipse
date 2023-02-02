package com.grupo5.reto2.user;

import java.util.Set;

import com.grupo5.reto2.role.Role;

public class UserServiceModel {

	private String dni;
	private boolean isEnabled;
	private Set<Role> roles;

	public UserServiceModel() {
		super();
	}

	public UserServiceModel(String dni, boolean isEnabled, Set<Role> roles) {
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserServiceModel [dni=" + dni + ", isEnabled=" + isEnabled + ", roles=" + roles + "]";
	}

}
