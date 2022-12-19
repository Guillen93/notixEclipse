package com.grupo5.reto2.absence;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="absence")
public class Absence {
	
	private Integer absenceID;
	@Column()
	private Integer subjectID;
	@Column(length = 9)
	private String studentDNI;
	@Column()
	private Date foul;
	@Column()
	private boolean justified = false;
	
	public Absence() {
		super();
	}
	public Absence(Integer absenceID, Integer subjectID, String studentDNI, Date foul, boolean justified) {
		super();
		this.absenceID = absenceID;
		this.subjectID = subjectID;
		this.studentDNI = studentDNI;
		this.foul = foul;
		this.justified = justified;
	}
	
	public Integer getAbsenceID() {
		return absenceID;
	}
	public void setAbsenceID(Integer absenceID) {
		this.absenceID = absenceID;
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
	public Date getFoul() {
		return foul;
	}
	public void setFoul(Date foul) {
		this.foul = foul;
	}
	public boolean isJustified() {
		return justified;
	}
	public void setJustified(boolean justified) {
		this.justified = justified;
	}
	
}
