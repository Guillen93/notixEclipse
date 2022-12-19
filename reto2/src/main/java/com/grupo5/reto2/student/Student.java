package com.grupo5.reto2.student;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(length = 9)
	private String DNI;
	@Column(length = 100)
	private String name;
	@Column(length = 100)
	private String surname;
	@Column()
	private Date bornDate;
	@Column(length = 100)
	private String nationality;
	@Column(length = 100)
	private String email;
	@Column(length = 9)
	private String phone;
	@Column(length = 255)
	private String photo;
	
	public Student() {
		super();
	}

	public Student(String dNI, String name, String surname, Date bornDate, String nationality, String email,
			String phone, String photo) {
		super();
		DNI = dNI;
		this.name = name;
		this.surname = surname;
		this.bornDate = bornDate;
		this.nationality = nationality;
		this.email = email;
		this.phone = phone;
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
