package com.grupo5.reto2.professor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grupo5.reto2.gradeEdition.GradeEdition;
import com.grupo5.reto2.subject.Subject;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {
	@Id
	private String professorDni;
	
	@Column()
	private String name;
	
	@Column()
	private String surname;
	
	@Column()
	private String nationality;
	
	@Column()
	private String email;
	
	@Column()
	private String addres;
	
	@Column()
	private String photo;
	
	@OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<GradeEdition> gradeEditions;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Subject> subjects;
	
	public Professor() {
		super();
	}

	public Professor(String professorDni, String nationality, String addres, String photo) {
		super();
		this.professorDni = professorDni;
		this.nationality = nationality;
		this.addres = addres;
		this.photo = photo;
	}

	public Professor(String professorDni, String name, String surname, String nationality, String email, String addres,
			String photo) {
		super();
		this.professorDni = professorDni;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.email = email;
		this.addres = addres;
		this.photo = photo;
	}

	public Professor(String professorDni, String name, String surname, String nationality, String email, String addres,
			String photo, List<GradeEdition> gradeEditions, List<Subject> subjects) {
		super();
		this.professorDni = professorDni;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.email = email;
		this.addres = addres;
		this.photo = photo;
		this.gradeEditions = gradeEditions;
		this.subjects = subjects;
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
	public List<GradeEdition> getGradeEditions() {
		return gradeEditions;
	}
	public void setGradeEditions(List<GradeEdition> gradeEditions) {
		this.gradeEditions = gradeEditions;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Professor [professorDni=" + professorDni + ", name=" + name + ", surname=" + surname + ", nationality="
				+ nationality + ", email=" + email + ", addres=" + addres + ", photo=" + photo + ", gradeEditions="
				+ gradeEditions + ", subjects=" + subjects + "]";
	}
	
}
