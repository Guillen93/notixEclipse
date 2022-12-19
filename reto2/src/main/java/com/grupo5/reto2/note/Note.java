package com.grupo5.reto2.note;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="note")
public class Note {

	private Integer noteID;
	@Column()
	private Integer subjectID;
	@Column(length = 9)
	private String studentDNI;
	@Column()
	private Float eva1;
	@Column()
	private Float eva2;
	@Column()
	private Float eva3;
	@Column()
	private Integer final1;
	@Column()
	private Integer final2;
	
	public Note() {
		super();
	}
	
	public Note(Integer noteID, Integer subjectID, String studentDNI, Float eva1, Float eva2, Float eva3, Integer final1,
			Integer final2) {
		super();
		this.noteID = noteID;
		this.subjectID = subjectID;
		this.studentDNI = studentDNI;
		this.eva1 = eva1;
		this.eva2 = eva2;
		this.eva3 = eva3;
		this.final1 = final1;
		this.final2 = final2;
	}

	public Integer getNoteID() {
		return noteID;
	}

	public void setNoteID(Integer noteID) {
		this.noteID = noteID;
	}

	public Integer getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}

	public String getStudentDNI() {
		return studentDNI;
	}

	public void setStudentDNI(String studentDNI) {
		this.studentDNI = studentDNI;
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

}
