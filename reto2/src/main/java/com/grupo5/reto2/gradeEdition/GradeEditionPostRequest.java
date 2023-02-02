package com.grupo5.reto2.gradeEdition;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class GradeEditionPostRequest {

	private Integer gradeEditionId;

	private Integer gradeId;
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]")
	private String tutorDni;
	@Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	private String fecha;

	public GradeEditionPostRequest() {
		super();
	}

	public GradeEditionPostRequest(
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Integer gradeId,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") @Pattern(regexp = "[0-9]{7,8}[A-Z a-z]") String tutorDni,
			String fecha) {
		super();
		this.gradeId = gradeId;
		this.tutorDni = tutorDni;
		this.fecha = fecha;
	}

	public GradeEditionPostRequest(Integer gradeEditionId,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Integer gradeId,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") @Pattern(regexp = "[0-9]{7,8}[A-Z a-z]") String tutorDni,
			String fecha) {
		super();
		this.gradeEditionId = gradeEditionId;
		this.gradeId = gradeId;
		this.tutorDni = tutorDni;
		this.fecha = fecha;
	}

	public Integer getGradeEdId() {
		return gradeEditionId;
	}

	public void setGradeEdId(Integer gradeEdId) {
		this.gradeEditionId = gradeEdId;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getTutorDni() {
		return tutorDni;
	}

	public void setTutorDni(String tutorDni) {
		this.tutorDni = tutorDni;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "GradeEditionPostRequest [gradeEdId=" + gradeEditionId + ", gradeId=" + gradeId + ", tutorDni="
				+ tutorDni + ", fecha=" + fecha + "]";
	}

}
