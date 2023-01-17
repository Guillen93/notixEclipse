package com.grupo5.reto2.gradeEdition;

public class GradeEditionServiceModel {
	
	private Integer gradeEditionId;
	private Integer gradeId;
	private String tutorDni;
	private String fecha;
	
	public GradeEditionServiceModel() {
		super();
	}
	
	public GradeEditionServiceModel(Integer gradeEdId, Integer gradeId, String tutorDni, String date) {
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "GradeEditionServiceModel [gradeEdId=" + gradeEditionId + ", gradeId=" + gradeId + ", tutorDni=" + tutorDni
				+ ", fecha=" + fecha + "]";
	}

}
