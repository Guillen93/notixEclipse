package com.grupo5.reto2.note;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grupo5.reto2.student.Student;
import com.grupo5.reto2.subject.Subject;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Note {

	@EmbeddedId
	private NoteId id = new NoteId();

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("studentDni")
	@JoinColumn(name = "studentDni", foreignKey = @ForeignKey(name = "fk_studentNote"))
	//@JsonManagedReference
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Student studentNote;
	@Column(name = "studentDni", updatable = false, insertable = false)
	private String studentDni;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("subjectId")
	@JoinColumn(name = "subjectId", foreignKey = @ForeignKey(name = "fk_subjectNote"))
	//@JsonManagedReference
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Subject subject;
	@Column(name = "subjectId", updatable = false, insertable = false)
	private Integer subjectId;

	@Column()
	private Float eva1;

	@Column()
	private Float eva2;

	@Column()
	private Float eva3;

	@Column()
	private Integer final1;

	@Column()
	private Integer final2;

	public Note() {
		super();
	}

	public Note(String studentDni, Integer subjectId, Float eva1, Float eva2, Float eva3, Integer final1,
			Integer final2) {
		super();
		this.studentDni = studentDni;
		this.subjectId = subjectId;
		this.eva1 = eva1;
		this.eva2 = eva2;
		this.eva3 = eva3;
		this.final1 = final1;
		this.final2 = final2;
	}

	public Note(Student studentNote, String studentDni, Subject subject, Integer subjectId, Float eva1, Float eva2,
			Float eva3, Integer final1, Integer final2) {
		super();
		this.studentNote = studentNote;
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
		return studentNote;
	}

	public void setStudent(Student studentNote) {
		this.studentNote = studentNote;
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

	public Student getStudentNote() {
		return studentNote;
	}

	public void setStudentNote(Student studentNote) {
		this.studentNote = studentNote;
	}

	@Override
	public String toString() {
		return "Note [student=" + studentNote + ", studentDni=" + studentDni + ", subject=" + subject + ", subjectId="
				+ subjectId + ", eva1=" + eva1 + ", eva2=" + eva2 + ", eva3=" + eva3 + ", final1=" + final1
				+ ", final2=" + final2 + "]";
	}

}
