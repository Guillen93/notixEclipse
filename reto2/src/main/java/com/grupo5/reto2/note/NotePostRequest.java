package com.grupo5.reto2.note;

import com.grupo5.reto2.student.Student;
import com.grupo5.reto2.subject.Subject;

public class NotePostRequest {

	private NoteId id;
	private Student student;
	private String studentDni;
	private Subject subject;
	private Integer subjectId;
	private Float eva1;
	private Float eva2;
	private Float eva3;
	private Integer final1;
	private Integer final2;

	public NotePostRequest() {
		super();
	}

	public NotePostRequest(Student student, String studentDni, Subject subject, Integer subjectId, Float eva1,
			Float eva2, Float eva3, Integer final1, Integer final2) {
		super();
		this.student = student;
		this.studentDni = studentDni;
		this.subject = subject;
		this.subjectId = subjectId;
		this.eva1 = eva1;
		this.eva2 = eva2;
		this.eva3 = eva3;
		this.final1 = final1;
		this.final2 = final2;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStudentDni() {
		return studentDni;
	}

	public void setStudentDni(String studentDni) {
		this.studentDni = studentDni;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Float getEva1() {
		return eva1;
	}

	public void setEva1(Float eva1) {
		this.eva1 = eva1;
	}

	public Float getEva2() {
		return eva2;
	}

	public void setEva2(Float eva2) {
		this.eva2 = eva2;
	}

	public Float getEva3() {
		return eva3;
	}

	public void setEva3(Float eva3) {
		this.eva3 = eva3;
	}

	public Integer getFinal1() {
		return final1;
	}

	public void setFinal1(Integer final1) {
		this.final1 = final1;
	}

	public Integer getFinal2() {
		return final2;
	}

	public void setFinal2(Integer final2) {
		this.final2 = final2;
	}

	public NoteId getId() {
		return id;
	}

	public void setId(NoteId id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return "NotePostRequest [student=" + student + ", studentDni=" + studentDni + ", subject="
				+ subject + ", subjectId=" + subjectId + ", eva1=" + eva1 + ", eva2=" + eva2 + ", eva3=" + eva3
				+ ", final1=" + final1 + ", final2=" + final2 + "]";
	}

}
