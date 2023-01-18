package com.grupo5.reto2.note;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class NotePostRequest {

	private NoteId id;
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	@Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z a-z]")
	private String studentDni;
	@NotNull(message = "el campo no puede ser nulo")
	private Integer subjectId;
	@NotNull(message = "el campo no puede ser nulo")
	@Min(0)
	@Max(10)
	private Float eva1;
	@NotNull(message = "el campo no puede ser nulo")
	@Min(0)
	@Max(10)
	private Float eva2;
	@NotNull(message = "el campo no puede ser nulo")
	@Min(0)
	@Max(10)
	private Float eva3;
	@NotNull(message = "el campo no puede ser nulo")
	@Min(0)
	@Max(10)
	private Integer final1;
	@NotNull(message = "el campo no puede ser nulo")
	@Min(0)
	@Max(10)
	private Integer final2;

	public NotePostRequest() {
		super();
	}

	public NotePostRequest(NoteId id,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") @Pattern(regexp = "[0-9]{7,8}[A-Z a-z]") String studentDni,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Integer subjectId,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Float eva1,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Float eva2,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Float eva3,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Integer final1,
			@NotNull(message = "el campo no puede ser nulo") @NotEmpty(message = "el campo no puede estar vacio") Integer final2) {
		super();
		this.id = id;
		this.studentDni = studentDni;
		this.subjectId = subjectId;
		this.eva1 = eva1;
		this.eva2 = eva2;
		this.eva3 = eva3;
		this.final1 = final1;
		this.final2 = final2;
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

	public Float getEva1() {
		return eva1;
	}

	public void setEva1(Float eva1) {
		this.eva1 = eva1;
	}

	public Float getEva2() {
		return eva2;
	}

	public void setEva2(Float eva2) {
		this.eva2 = eva2;
	}

	public Float getEva3() {
		return eva3;
	}

	public void setEva3(Float eva3) {
		this.eva3 = eva3;
	}

	public Integer getFinal1() {
		return final1;
	}

	public void setFinal1(Integer final1) {
		this.final1 = final1;
	}

	public Integer getFinal2() {
		return final2;
	}

	public void setFinal2(Integer final2) {
		this.final2 = final2;
	}

	public NoteId getId() {
		return id;
	}

	public void setId(NoteId id) {
		this.id = id;
	}

}