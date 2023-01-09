package com.grupo5.reto2.note;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NoteId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column
	private String studentDni;
	@Column
	private Integer subjectId;
	
	public NoteId() {
		super();
	}

	public NoteId(String studentDni, Integer subjectId) {
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
		return "NoteId [studentDni=" + studentDni + ", subjectId=" + subjectId + "]";
	}
	
	
}
