package com.grupo5.reto2.absence;

import java.util.Date;

public class AbsencePostRequest {

	private AbsenceId id = new AbsenceId();
	private String studentDni;
	private Integer subjectId;
	private Date foul;
	private boolean justified = false;

	public AbsencePostRequest() {
		super();
	}

	public AbsencePostRequest(AbsenceId id, String studentDni, Integer subjectId, Date foul, boolean justified) {
		super();
		this.id = id;
		this.studentDni = studentDni;
		this.subjectId = subjectId;
		this.foul = foul;
		this.justified = justified;
	}

	public AbsenceId getId() {
		return id;
	}

	public void setId(AbsenceId id) {
		this.id = id;
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

	public boolean isJustified() {
		return justified;
	}

	public void setJustified(boolean justified) {
		this.justified = justified;
	}

	@Override
	public String toString() {
		return "AbsencePostRequest [id=" + id + ", studentDni=" + studentDni + ", subjectId=" + subjectId + ", foul="
				+ foul + ", justified=" + justified + "]";
	}

}
