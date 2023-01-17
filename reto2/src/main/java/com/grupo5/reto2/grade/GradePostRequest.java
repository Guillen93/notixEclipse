package com.grupo5.reto2.grade;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class GradePostRequest {


	private Integer gradeId;
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	private String name;
	@Pattern(regexp = "IN|ES", message = "idioma invalido[IN | ES]")
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	private String language;

	public GradePostRequest() {
		super();
	}

	public GradePostRequest(Integer gradeId,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") String name,
			@Pattern(regexp = "IN|ES", message = "idioma invalido[IN | ES]") @NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") String language) {
		super();
		this.gradeId = gradeId;
		this.name = name;
		this.language = language;
	}


	public GradePostRequest(String name, String language) {
		super();
		this.name = name;
		this.language = language;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "GradePostRequest [gradeId=" + gradeId + ", name=" + name + ", language=" + language + "]";
	}

}
