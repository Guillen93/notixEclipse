package com.grupo5.reto2.gradeEdition;

import java.sql.Date;

public class GradeEditionServiceModel {
	
	private Integer gradeEditionId;
	private Integer gradeId;
	private String tutorDni;
	private Date fecha;
	
	public GradeEditionServiceModel() {
		super();
	}
	
	public GradeEditionServiceModel(Integer gradeEdId, Integer gradeId, String tutorDni, Date date) {
		super();
		this.gradeEditionId = gradeEdId;
		this.gradeId = gradeId;
		this.tutorDni = tutorDni;
		this.fecha =  date;
	}

	public Integer getGradeEdId() {
		return gradeEditionId;
	}

	public void setGradeEdId(Integer gradeEdId) {
		this.gradeEditionId = gradeEdId;
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
		return "GradeEditionServiceModel [gradeEdId=" + gradeEditionId + ", gradeId=" + gradeId + ", tutorDni=" + tutorDni
				+ ", fecha=" + fecha + "]";
	}

}
