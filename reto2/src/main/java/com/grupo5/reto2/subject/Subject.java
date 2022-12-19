package com.grupo5.reto2.subject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectID;
	@Column()
	private Integer gradeID;
	@Column(length = 9)
	private String professorDNI;
	@Column(length = 100)
	private String name;
	@Column()
	private Integer duration;
	
	public Subject() {
		super();
	}
	
	public Subject(Integer subjectID, Integer gradeID, String professorDNI, String name, Integer duration) {
		super();
		this.subjectID = subjectID;
		this.gradeID = gradeID;
		this.professorDNI = professorDNI;
		this.name = name;
		this.duration = duration;
	}

	public Integer getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}

	public Integer getGradeID() {
		return gradeID;
	}

	public void setGradeID(Integer gradeID) {
		this.gradeID = gradeID;
	}

	public String getProfessorDNI() {
		return professorDNI;
	}

	public void setProfessorDNI(String professorDNI) {
		this.professorDNI = professorDNI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
}
