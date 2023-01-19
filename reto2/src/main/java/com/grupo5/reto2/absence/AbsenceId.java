package com.grupo5.reto2.absence;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;

@Embeddable
public class AbsenceId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String studentDni;
	private Integer subjectId;
	@JoinColumn(name = "foul", foreignKey = @ForeignKey(name = "fk_foulAbsence"))
	@Column(name = "foul", updatable = false, insertable = false)
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
		return "AbsenceId [studentDni=" + studentDni + ", subjectId=" + subjectId + ", foul=" + foul + "]";
	}



}
