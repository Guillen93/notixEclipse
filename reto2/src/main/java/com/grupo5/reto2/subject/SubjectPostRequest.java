package com.grupo5.reto2.subject;

public class SubjectPostRequest {

	private Integer subjectId;
	private Integer gradeId;
	private String professorDni;
	private String name;
	private Integer duration;

	public SubjectPostRequest() {
		super();
	}

	public SubjectPostRequest(Integer subjectId, Integer gradeId, String professorDni, String name, Integer duration) {
		super();
		this.subjectId = subjectId;
		this.gradeId = gradeId;
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

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
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

}
