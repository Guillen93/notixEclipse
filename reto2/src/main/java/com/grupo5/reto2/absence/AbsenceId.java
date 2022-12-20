package com.grupo5.reto2.absence;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class AbsenceId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String studentDni;
	private Integer subjectId;
	
	public AbsenceId() {
		super();
	}

	public AbsenceId(String studentDni, Integer subjectId) {
		super();
		this.studentDni = studentDni;
		this.subjectId = subjectId;
	}

	public String getStudentDni() {
		return studentDni;
	}

	public void setStudentDni(String studentDni) {
		this.studentDni = studentDni;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "AbsenceId [studentDni=" + studentDni + ", subjectId=" + subjectId + "]";
	}
	
	
}
