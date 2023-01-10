package com.grupo5.reto2.professor;

public class ProfessorRequest {

	private String professorDni;
	private String name;
	private String surname;
	private String nationality;
	private String email;
	private String addres;
	private String photo;
		
	public ProfessorRequest() {
		super();
	}

	public ProfessorRequest(String professorDni, String name, String surname, String nationality, String email,
			String addres, String photo) {
		super();
		this.professorDni = professorDni;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.email = email;
		this.addres = addres;
		this.photo = photo;
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
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "ProfessorRequest [professorDni=" + professorDni + ", name=" + name + ", surname=" + surname
				+ ", nationality=" + nationality + ", email=" + email + ", addres=" + addres + ", photo=" + photo + "]";
	}

}
