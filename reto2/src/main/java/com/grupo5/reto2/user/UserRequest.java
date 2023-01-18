package com.grupo5.reto2.user;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
	@NotNull()
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]")
	private String dni;
	private String password;
	private Integer roleId;

	public UserRequest() {
	}

	public UserRequest(@NotNull @Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]") String dni,
			String password, Integer roleId) {
		super();
		this.dni = dni;
		this.password = password;
		this.roleId = roleId;
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
