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
	private Integer gradeId;
	
	@Column()
	private String name;
	
	@Column()
	private String language;
	
	public Grade() {
		super();
	}
	
	public Grade(Integer gradeId, String name, String language) {
		super();
		this.gradeId = gradeId;
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
		return "Grade [gradeId=" + gradeId + ", name=" + name + ", language=" + language + "]";
	}
	
	
}
