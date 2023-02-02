package com.grupo5.reto2.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class StudentPostRequest {

	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]")
	private String studentDni;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String name;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String surname;
	@Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	private String bornDate;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String nationality;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	@Email()
	private String email;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", message = "Formato telefono incorrecto")
	@Size(max = 9, min = 9)
	private String phone;

	private String photo;

	public StudentPostRequest() {
		super();
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

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
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

	@Override
	public String toString() {
		return "StudentPostRequest [studentDni=" + studentDni + ", name=" + name + ", surname=" + surname
				+ ", bornDate=" + bornDate + ", nationality=" + nationality + ", email=" + email + ", phone=" + phone
				+ ", photo=" + photo + "]";
	}

	
	
}
