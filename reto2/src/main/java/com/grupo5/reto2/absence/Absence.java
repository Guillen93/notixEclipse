package com.grupo5.reto2.absence;

import java.sql.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Absence {

	@EmbeddedId
	private AbsenceId id = new AbsenceId();

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("studentDni")
	@JoinColumn(name = "studentDni", foreignKey = @ForeignKey(name = "fk_studentAbsence"))
	@JsonManagedReference
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Student student;
	@Column(name = "studentDni", updatable = false, insertable = false)
	private String studentDni;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@MapsId("subjectId")
	@JoinColumn(name = "subjectId", foreignKey = @ForeignKey(name = "fk_subjectAbsence"))
	@JsonManagedReference
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Subject subject;
	@Column(name = "subjectId", updatable = false, insertable = false)
	private Integer subjectId;

	@MapsId("foul")
	@JoinColumn(name = "foul", foreignKey = @ForeignKey(name = "fk_foulAbsence"))
	@Column(name = "foul", updatable = false, insertable = false)
	private Date foul;

	@Column()
	private boolean justified = false;

	public Absence() {
		super();
	}

	public Absence(AbsenceId id, Student student, String studentDni, Subject subject, Integer subjectId, Date foul,
			boolean justified) {
		super();
		this.id = id;
		this.student = student;
		this.studentDni = studentDni;
		this.subject = subject;
		this.subjectId = subjectId;
		this.foul = foul;
		this.justified = justified;
	}

	public Absence(AbsenceId id, Student student, String studentDni, Subject subject, Integer subjectId,
			boolean justified) {
		super();
		this.id = id;
		this.student = student;
		this.studentDni = studentDni;
		this.subject = subject;
		this.subjectId = subjectId;
		this.justified = justified;
	}

	public Absence(Student student, String studentDni, Subject subject, Integer subjectId, boolean justified) {
		super();
		this.student = student;
		this.studentDni = studentDni;
		this.subject = subject;
		this.subjectId = subjectId;
		this.justified = justified;
	}

	public Absence(Object setId, Student student2, String studentDni2, Subject subject2, Integer subjectId2,
			boolean justified2) {
		// TODO Auto-generated constructor stub
	}

	public AbsenceId getId() {
		return id;
	}

	public void setId(AbsenceId id) {
		this.id = id;
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

	public boolean isJustified() {
		return justified;
	}

	public void setJustified(boolean justified) {
		this.justified = justified;
	}
	
	

	public Date getFoul() {
		return foul;
	}

	public void setFoul(Date foul) {
		this.foul = foul;
	}

	@Override
	public String toString() {
		return "Absence [student=" + student + ", studentDni=" + studentDni + ", subject=" + subject + ", subjectId="
				+ subjectId + ", foul=" + /* foul + */ ", justified=" + justified + "]";
	}

}
