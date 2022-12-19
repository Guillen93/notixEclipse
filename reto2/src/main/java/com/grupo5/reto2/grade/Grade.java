package com.grupo5.reto2.grade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="grade")
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gradeID;
	@Column(length = 100)
	private String name;
	@Column(length = 100)
	private String language;
	
	public Grade() {
		super();
	}
	public Grade(Integer gradeID, String name, String language) {
		super();
		this.gradeID = gradeID;
		this.name = name;
		this.language = language;
	}
	
	public Integer getGradeID() {
		return gradeID;
	}
	public void setGradeID(Integer gradeID) {
		this.gradeID = gradeID;
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
	
}
