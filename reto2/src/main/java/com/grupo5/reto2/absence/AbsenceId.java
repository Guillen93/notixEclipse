package com.grupo5.reto2.absence;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;

@Embeddable
public class AbsenceId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String studentDni;
	private Integer subjectId;
	private Date foul;

	public AbsenceId() {
		super();
	}

	public AbsenceId(String studentDni, Integer subjectId, Date foul) {
		super();
		this.studentDni = studentDni;
		this.subjectId = subjectId;
		this.foul = foul;
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

	public Date getFoul() {
		return foul;
	}

	public void setFoul(Date foul) {
		this.foul = foul;
	}

	@Override
	public String toString() {
		return "AbsenceId [studentDni=" + studentDni + ", subjectId=" + subjectId + "]";
	}

}
