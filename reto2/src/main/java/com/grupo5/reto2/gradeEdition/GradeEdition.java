package com.grupo5.reto2.gradeEdition;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="grade_edition")
public class GradeEdition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gradeEdID;
	@Column()
	private Integer gradeID;
	@Column(length = 9)
	private String tutorDNI;
	@Column()
	private Date fecha;
	
	public GradeEdition() {
		super();
	}
	
	public GradeEdition(Integer gradeEdID, Integer gradeID, String tutorDNI, Date fecha) {
		super();
		this.gradeEdID = gradeEdID;
		this.gradeID = gradeID;
		this.tutorDNI = tutorDNI;
		this.fecha = fecha;
	}

	public Integer getGradeEdID() {
		return gradeEdID;
	}

	public void setGradeEdID(Integer gradeEdID) {
		this.gradeEdID = gradeEdID;
	}

	public Integer getGradeID() {
		return gradeID;
	}

	public void setGradeID(Integer gradeID) {
		this.gradeID = gradeID;
	}

	public String getTutorDNI() {
		return tutorDNI;
	}

	public void setTutorDNI(String tutorDNI) {
		this.tutorDNI = tutorDNI;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
