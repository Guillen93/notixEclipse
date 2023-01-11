package com.grupo5.reto2.gradeEdition;

import java.sql.Date;

public class GradeEditionPostRequest {
	
	private Integer gradeEdId;
	private Integer gradeId;
	private String tutorDni;
	private Date fecha;
	
	public GradeEditionPostRequest() {
		super();
	}
	
	public GradeEditionPostRequest(Integer gradeId, String tutorDni, Date fecha) {
		super();
		this.gradeId = gradeId;
		this.tutorDni = tutorDni;
		this.fecha = fecha;
	}

	public GradeEditionPostRequest(Integer gradeEdId, Integer gradeId, String tutorDni, Date fecha) {
		super();
		this.gradeEdId = gradeEdId;
		this.gradeId = gradeId;
		this.tutorDni = tutorDni;
		this.fecha = fecha;
	}

	public Integer getGradeEdId() {
		return gradeEdId;
	}

	public void setGradeEdId(Integer gradeEdId) {
		this.gradeEdId = gradeEdId;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getTutorDni() {
		return tutorDni;
	}

	public void setTutorDni(String tutorDni) {
		this.tutorDni = tutorDni;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "GradeEditionPostRequest [gradeEdId=" + gradeEdId + ", gradeId=" + gradeId + ", tutorDni=" + tutorDni
				+ ", fecha=" + fecha + "]";
	}

}
