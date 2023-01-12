package com.grupo5.reto2.absence;

import java.util.Date;

import com.grupo5.reto2.student.Student;
import com.grupo5.reto2.subject.Subject;

public class AbsenceServiceModel {

	private AbsenceId id = new AbsenceId();
//	private Student student;
	private String studentDni;
//	private Subject subject;
	private Integer subjectId;
	private Date foul;
	private boolean justified = false;

	public AbsenceServiceModel() {
		super();
	}
	
	public AbsenceServiceModel(AbsenceId id,  String studentDni, Integer subjectId,
			Date foul, boolean justified) {
		super();
		this.id = id;
		this.studentDni = studentDni;
		this.subjectId = subjectId;
		this.foul = foul;
		this.justified = justified;
	}

	public AbsenceServiceModel(AbsenceId id, Student student, String studentDni, Subject subject, Integer subjectId,
			Date foul, boolean justified) {
		super();
		this.id = id;
//		this.student = student;
		this.studentDni = studentDni;
//		this.subject = subject;
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
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

	public String getStudentDni() {
		return studentDni;
	}

	public void setStudentDni(String studentDni) {
		this.studentDni = studentDni;
	}

//	public Subject getSubject() {
//		return subject;
//	}
//
//	public void setSubject(Subject subject) {
//		this.subject = subject;
//	}

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

//	@Override
//	public String toString() {
//		return "AbsenceServiceModel [id=" + id + ", student=" + student + ", studentDni=" + studentDni + ", subject="
//				+ subject + ", subjectId=" + subjectId + ", foul=" + foul + ", justified=" + justified + "]";
//	}
//	
	

}
