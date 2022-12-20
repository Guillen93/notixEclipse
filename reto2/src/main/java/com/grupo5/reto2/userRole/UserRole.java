/*
package com.grupo5.reto2.userRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name="user_role")
public class UserRole {

	private Integer userRoleID;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "roleID", foreignKey=@ForeignKey(name = "fK_roleID"))
	@Column()
	private Integer roleID;	
	@Column(length = 9)
	private String userDNI;
	
	public UserRole() {
		super();
	}
	
	public UserRole(Integer userRoleID, Integer roleID, String userDNI) {
		super();
		this.userRoleID = userRoleID;
		this.roleID = roleID;
		this.userDNI = userDNI;
	}

	public Integer getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(Integer userRoleID) {
		this.userRoleID = userRoleID;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getUserDNI() {
		return userDNI;
	}

	public void setUserDNI(String userDNI) {
		this.userDNI = userDNI;
	}

}
*/