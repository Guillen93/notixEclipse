package com.grupo5.reto2.professor;

public class ProfessorResponse {

	private String professorDni;
	private String name;
	private String surname;
	private String email;
	private String photo;
	private String nationality;
	private String addres;

	public ProfessorResponse() {
		super();
	}

	public ProfessorResponse(String professorDni, String name, String surname, String email, String photo,
			String nationality, String addres) {
		super();
		this.professorDni = professorDni;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.photo = photo;
		this.nationality = nationality;
		this.addres = addres;
	}

	public String getProfessorDni() {
		return professorDni;
	}

	public void setProfessorDni(String professorDni) {
		this.professorDni = professorDni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	@Override
	public String toString() {
		return "ProfessorResponse [professorDni=" + professorDni + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", photo=" + photo + ", nationality=" + nationality + ", addres=" + addres + "]";
	}

}
