package com.grupo5.reto2.student;

public class PromotionPostRequest {

	String studentDni;

	Integer gradeEditionId;

	public PromotionPostRequest() {
		super();
	}

	public PromotionPostRequest(String studentDni, Integer gradeEditionId) {
		super();
		this.studentDni = studentDni;
		this.gradeEditionId = gradeEditionId;
	}

	public String getStudentDni() {
		return studentDni;
	}

	public void setStudentDni(String studentDni) {
		this.studentDni = studentDni;
	}

	public Integer getGradeEditionId() {
		return gradeEditionId;
	}

	public void setGradeEditionId(Integer gradeEditionId) {
		this.gradeEditionId = gradeEditionId;
	}

	@Override
	public String toString() {
		return "PromotionPostRequest [studentDni=" + studentDni + ", gradeEditionId=" + gradeEditionId + "]";
	}

}
