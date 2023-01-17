package com.grupo5.reto2.student;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StudentPostRequest {
	
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	@Pattern(regexp = "[0-9]{7,8}[A-Z a-z]", message = "Formato DNI incorrecto")
	private String studentDni;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String name;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String surname;

	
	private Date bornDate;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String nationality;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String email;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String phone;
	@NotNull(message = "Campo no nulo")
	@NotEmpty(message = "Campo no puede ser vacio")
	private String photo;

	public StudentPostRequest() {
		super();
	}



	public StudentPostRequest(
			@NotNull @NotEmpty @Pattern(regexp = "[0-9]{7,8}[A-Z a-z]", message = "Formato DNI incorrecto") String studentDni,
			@NotNull(message = "Campo no nulo") @NotEmpty String name,
			@NotNull(message = "Campo no nulo") @NotEmpty String surname, Date bornDate,
			@NotNull(message = "Campo no nulo") @NotEmpty String nationality,
			@NotNull(message = "Campo no nulo") @NotEmpty String email,
			@NotNull(message = "Campo no nulo") @NotEmpty String phone,
			@NotNull(message = "Campo no nulo") @NotEmpty String photo) {
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
