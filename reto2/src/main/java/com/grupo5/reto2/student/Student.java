package com.grupo5.reto2.student;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grupo5.reto2.absence.Absence;
import com.grupo5.reto2.gradeEdition.GradeEdition;
import com.grupo5.reto2.note.Note;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="student")
public class Student {
	@Id
	private String studentDni;
	
	@Column()
	private String name;
	
	@Column()
	private String surname;
	
	@Column()
	private Date bornDate;
	
	@Column()
	private String nationality;
	
	@Column()
	private String email;
	
	@Column(length = 9)
	private String phone;
	
	@Column()
	private String photo;

	@OneToMany(mappedBy = "studentDni", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Note> notes = new HashSet<>();

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Absence> absences = new HashSet<>();	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "promotion",
		joinColumns = @JoinColumn(
				name = "studentDni", referencedColumnName = "studentDni", foreignKey = @ForeignKey(name = "fk_student_promotion")
		),
		inverseJoinColumns = @JoinColumn(
				name = "gradeId", referencedColumnName = "gradeEdId", foreignKey = @ForeignKey(name = "fk_gradeEd_promotion")
		)
	)
	private Set<GradeEdition> promotions = new HashSet<>();
	
	public Student() {
		super();
	}
	public Student(String studentDni, String name, String surname, Date bornDate, String nationality, String email,
			String phone, String photo) {
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


	public Student(String studentDni, String name, String surname, Date bornDate, String nationality, String email,
			String phone, String photo, Set<Note> notes, Set<Absence> absences, Set<GradeEdition> promotions) {
		super();
		this.studentDni = studentDni;
		this.name = name;
		this.surname = surname;
		this.bornDate = bornDate;
		this.nationality = nationality;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
		this.notes = notes;
		this.absences = absences;
		this.promotions = promotions;
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
	public Set<Note> getNotes() {
		return notes;
	}
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}
	public Set<Absence> getAbsences() {
		return absences;
	}
	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}
	public Set<GradeEdition> getPromotions() {
		return promotions;
	}
	public void setPromotions(Set<GradeEdition> promotions) {
		this.promotions = promotions;
	}

	@Override
	public String toString() {
		return "Student [studentDni=" + studentDni + ", name=" + name + ", surname=" + surname + ", bornDate="
				+ bornDate + ", nationality=" + nationality + ", email=" + email + ", phone=" + phone + ", photo="
				+ photo + ", notes=" + notes + ", absences=" + absences + ", promotions=" + promotions + "]";
	}

	
}
