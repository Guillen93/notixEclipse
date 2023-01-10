package com.grupo5.reto2.grade;

public class GradePostRequest {

	private Integer gradeId;
	private String name;
	private String language;
	
	public GradePostRequest() {
		super();
	}
	
	public GradePostRequest(Integer gradeId, String name, String language) {
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
