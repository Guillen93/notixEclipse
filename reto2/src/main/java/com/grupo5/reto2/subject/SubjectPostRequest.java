package com.grupo5.reto2.subject;

public class SubjectPostRequest {

	private Integer subjectId;
	private Integer gradeEditionId;
	private String professorDni;
	private String name;
	private Integer duration;
	public SubjectPostRequest() {
		super();
	}
	public SubjectPostRequest(Integer subjectId, Integer gradeEditionId, String professorDni, String name,
			Integer duration) {
		super();
		this.subjectId = subjectId;
		this.gradeEditionId = gradeEditionId;
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
	public void setGradeEditionId(Integer gradeEditionId) {
		this.gradeEditionId = gradeEditionId;
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
		return "SubjectPostRequest [subjectId=" + subjectId + ", gradeEditionId=" + gradeEditionId + ", professorDni="
				+ professorDni + ", name=" + name + ", duration=" + duration + "]";
	}

	
}