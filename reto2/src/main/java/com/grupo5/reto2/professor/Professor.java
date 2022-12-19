package com.grupo5.reto2.professor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {
	@Id
	@Column(length = 9)
	private String DNI;
	@Column(length = 100)
	private String name;
	@Column(length = 100)
	private String surname;
	@Column(length = 100)
	private String nationality;
	@Column(length = 100)
	private String email;
	@Column(length = 100)
	private String addres;
	@Column(length = 255)
	private String photo;
	
	public Professor() {
		super();
	}
	
	public Professor(String dNI, String name, String surname, String nationality, String email, String addres,
			String photo) {
		super();
		DNI = dNI;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.email = email;
		this.addres = addres;
		this.photo = photo;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
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
	
}
