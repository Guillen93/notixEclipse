package com.grupo5.reto2.subject;

public class SubjectServiceModel {

	private Integer subjectId;
	private Integer gradeEditionId;
	private String professorDni;
	private String name;
	private Integer duration;

	public SubjectServiceModel() {
		super();
	}

	public SubjectServiceModel(Integer gradeEdId, String professorDni, String name, Integer duration) {
		super();
		this.gradeEditionId = gradeEdId;
		this.professorDni = professorDni;
		this.name = name;
		this.duration = duration;
	}

	public SubjectServiceModel(Integer subjectId, Integer gradeEdId, String professorDni, String name,
			Integer duration) {
		super();
		this.subjectId = subjectId;
		this.gradeEditionId = gradeEdId;
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

	public Integer getGradeEditionId() {
		return gradeEditionId;
	}

	public void setGradeEditionId(Integer gradeEdId) {
		this.gradeEditionId = gradeEdId;
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
		return "SubjectServiceModel [subjectId=" + subjectId + ", gradeEdId=" + gradeEditionId + ", professorDni="
				+ professorDni + ", name=" + name + ", duration=" + duration + "]";
	}

}