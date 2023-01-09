package com.grupo5.reto2.student;

import java.util.Date;

public class StudentPostRequest {

	private String studentDni;

	private String name;

	private String surname;

	private Date bornDate;

	private String nationality;

	private String email;

	private String phone;

	private String photo;

	public StudentPostRequest() {
		super();
	}

	public StudentPostRequest(String studentDni, String name, String surname, Date bornDate, String nationality,
			String email, String phone, String photo) {
		super();
		this.studentDni = studentDni;
		this.name = name;
		this.surname = surname;
		this.bornDate = bornDate;
		this.nationality = nationality;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
	}

	public String getStudentDni() {
		return studentDni;
	}

	public void setStudentDni(String studentDni) {
		this.studentDni = studentDni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
