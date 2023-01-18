package com.grupo5.reto2.absence;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AbsencePostRequest {

	private AbsenceId id = new AbsenceId();
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]")
	private String studentDni;
	@NotNull(message = "el campo no puede ser nulo")
	private Integer subjectId;
	@Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	private String foul;
	
	
	private boolean justified = false;

	public AbsencePostRequest() {
		super();
	}

	public AbsencePostRequest(AbsenceId id,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") @Pattern(regexp = "[0-9]{7,8}[A-Z a-z]") String studentDni,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Integer subjectId,
			@Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))") @NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") String foul,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") boolean justified) {
		super();
		this.id = id;
		this.studentDni = studentDni;
		this.subjectId = subjectId;
		this.foul = foul;
		this.justified = justified;
	}

	public AbsenceId getId() {
		return id;
	}

	public void setId(AbsenceId id) {
		this.id = id;
	}

	public String getStudentDni() {
		return studentDni;
	}

	public void setStudentDni(String studentDni) {
		this.studentDni = studentDni;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getFoul() {
		return foul;
	}

	public void setFoul(String foul) {
		this.foul = foul;
	}

	public boolean isJustified() {
		return justified;
	}

	public void setJustified(boolean justified) {
		this.justified = justified;
	}

	@Override
	public String toString() {
		return "AbsencePostRequest [id=" + id + ", studentDni=" + studentDni + ", subjectId=" + subjectId + ", foul="
				+ foul + ", justified=" + justified + "]";
	}




}
