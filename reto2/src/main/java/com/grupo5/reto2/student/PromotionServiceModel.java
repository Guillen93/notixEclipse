package com.grupo5.reto2.student;

public class PromotionServiceModel {

	private String studentDni;
	private String name;
	private String surname;
	private String bornDate;
	private String nationality;
	private String email;
	private String phone;
	private String photo;
	private String fechaGradeEdition;

	public PromotionServiceModel() {
		super();
	}

	public PromotionServiceModel(String studentDni, String name, String surname, String bornDate, String nationality,
			String email, String phone, String photo, String fechaGradeEdition) {
		super();
		this.studentDni = studentDni;
		this.name = name;
		this.surname = surname;
		this.bornDate = bornDate;
		this.nationality = nationality;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
		this.fechaGradeEdition = fechaGradeEdition;
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

	public String getFechaGradeEdition() {
		return fechaGradeEdition;
	}

	public void setFechaGradeEdition(String fechaGradeEdition) {
		this.fechaGradeEdition = fechaGradeEdition;
	}

	@Override
	public String toString() {
		return "PromotionServiceModel [studentDni=" + studentDni + ", name=" + name + ", surname=" + surname
				+ ", bornDate=" + bornDate + ", nationality=" + nationality + ", email=" + email + ", phone=" + phone
				+ ", photo=" + photo + ", fechaGradeEdition=" + fechaGradeEdition + "]";
	}

}
