package com.grupo5.reto2.subject;

import com.grupo5.reto2.gradeEdition.GradeEdition;
import com.grupo5.reto2.professor.Professor;

public class SubjectServiceModel {

	private Integer subjectId;
	private Integer gradeEdId;
	private Professor professor;
	private String professorDni;
	private String name;
	private Integer duration;

	public SubjectServiceModel() {
		super();
	}

	public SubjectServiceModel(Integer subjectId, Integer gradeId, String professorDni, String name, Integer duration) {
		super();
		this.gradeEdId = gradeId;
		this.professorDni = professorDni;
		this.name = name;
		this.duration = duration;
	}

	public SubjectServiceModel( Integer gradeId, Professor professor, String professorDni,
			String name, Integer duration) {
		super();
		this.gradeEdId = gradeId;
		this.professor = professor;
		this.professorDni = professorDni;
		this.name = name;
		this.duration = duration;
	}

	public SubjectServiceModel(Integer subjectId, Integer gradeId, Professor professor,
			String professorDni, String name, Integer duration) {
		super();
		this.subjectId = subjectId;
		this.gradeEdId = gradeId;
		this.professor = professor;
		this.professorDni = professorDni;
		this.name = name;
		this.duration = duration;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getGradeEdId() {
		return gradeEdId;
	}

	public void setGradeEdId(Integer gradeEdId) {
		this.gradeEdId = gradeEdId;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getProfessorDni() {
		return professorDni;
	}

	public void setProfessorDni(String professorDni) {
		this.professorDni = professorDni;
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

	@Override
	public String toString() {
		return "SubjectServiceModel [subjectId=" + subjectId + ", gradeEdId=" + gradeEdId
				+ ", professor=" + professor + ", professorDni=" + professorDni + ", name=" + name + ", duration="
				+ duration + "]";
	}

}