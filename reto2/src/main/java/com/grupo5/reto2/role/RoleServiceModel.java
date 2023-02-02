package com.grupo5.reto2.role;

public class RoleServiceModel {

	private Integer roleID;

	private String role;

	public RoleServiceModel() {
		super();
	}

	public RoleServiceModel(Integer roleID, String role) {
		super();
		this.roleID = roleID;
		this.role = role;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RoleServiceModel [roleID=" + roleID + ", role=" + role + "]";
	}

}
