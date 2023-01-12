package com.grupo5.reto2.user;

public class UserServiceModel {

	
	private String dni;
	private boolean isEnabled;
	
	
	
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
	@Override
	public String toString() {
		return "UserServiceModel [dni=" + dni +", isEnabled=" + isEnabled + "]";
	}
	public UserServiceModel(String dni, boolean isEnabled) {
		super();
		this.dni = dni;
		this.isEnabled = isEnabled;
	}
	
}
