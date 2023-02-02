package com.grupo5.reto2.subject;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SubjectPostRequest {

	private Integer subjectId;
	private Integer gradeEditionId;
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]")
	private String professorDni;
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
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