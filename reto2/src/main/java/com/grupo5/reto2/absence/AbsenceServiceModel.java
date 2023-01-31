package com.grupo5.reto2.absence;

import com.grupo5.reto2.student.Student;
import com.grupo5.reto2.subject.Subject;

public class AbsenceServiceModel {

	private AbsenceId id = new AbsenceId();
	private String studentDni;
	private Integer subjectId;
	private String foul;
	private boolean justified = false;

	public AbsenceServiceModel() {
		super();
	}

	public AbsenceServiceModel(AbsenceId id, String studentDni, Integer subjectId, String foul, boolean justified) {
		super();
		this.id = id;
		this.studentDni = studentDni;
		this.subjectId = subjectId;
		this.foul = foul;
		this.justified = justified;
	}

	public AbsenceServiceModel(AbsenceId id, Student student, String studentDni, Subject subject, Integer subjectId,
			String foul, boolean justified) {
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

	public String getFoul() {
		return foul;
	}

	public void setFoul(String foul) {
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
		return "AbsenceServiceModel [id=" + id + ", studentDni=" + studentDni + ", subjectId=" + subjectId + ", foul="
				+ foul + ", justified=" + justified + "]";
	}

}
