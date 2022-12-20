package com.grupo5.reto2.student;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.grupo5.reto2.gradeEdition.GradeEdition;
import com.grupo5.reto2.subject.Subject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "note",
		joinColumns = @JoinColumn(
				name = "studentDNI", referencedColumnName = "studentDni", foreignKey = @ForeignKey(name = "fk_student_note")
		),
		inverseJoinColumns = @JoinColumn(
				name = "subjectId", referencedColumnName = "subjectId", foreignKey = @ForeignKey(name = "fk_subject_note")
		)
	)
	private Set<Subject> notes = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "absence",
		joinColumns = @JoinColumn(
				name = "studentDni", referencedColumnName = "studentDni", foreignKey = @ForeignKey(name = "fk_student_absence")
		),
		inverseJoinColumns = @JoinColumn(
				name = "subjectId", referencedColumnName = "subjectId", foreignKey = @ForeignKey(name = "fk_subject_absence")
		)
	)
	private Set<Subject> absences = new HashSet<>();
	
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
			String phone, String photo, Set<Subject> notes, Set<Subject> absences,
			Set<GradeEdition> promotions) {
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
	public Set<Subject> getNotes() {
		return notes;
	}
	public void setNotes(Set<Subject> notes) {
		this.notes = notes;
	}
	public Set<Subject> getAbsences() {
		return absences;
	}
	public void setAbsences(Set<Subject> absences) {
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
