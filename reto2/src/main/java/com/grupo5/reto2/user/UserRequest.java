package com.grupo5.reto2.user;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
	@NotNull()
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]")
	private String dni;
	private String password;
	private Integer roleId;
	private boolean isEnabled;

	public UserRequest() {
	}

	public UserRequest(@NotNull @Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]") String dni,
			String password, Integer roleId, boolean isEnabled) {
		super();
		this.dni = dni;
		this.password = password;
		this.roleId = roleId;
		this.isEnabled = isEnabled;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRequest [dni=" + dni + ", password=" + password + ", roleId=" + roleId + "]";
	}

}
