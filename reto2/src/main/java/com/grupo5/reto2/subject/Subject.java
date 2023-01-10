package com.grupo5.reto2.subject;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grupo5.reto2.absence.Absence;
import com.grupo5.reto2.gradeEdition.GradeEdition;
import com.grupo5.reto2.note.Note;
import com.grupo5.reto2.professor.Professor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gradeId", foreignKey=@ForeignKey(name = "fk_gradeEdId"))
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private GradeEdition grade;
	@Column(name = "gradeId", updatable = false, insertable = false)
	private Integer gradeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professorDni", foreignKey=@ForeignKey(name = "fk_professorDni"))
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Professor professor;
	@Column(name = "professorDni", updatable = false, insertable = false)
	private String professorDni;
	
	@Column(length = 100)
	private String name;
	
	@Column()
	private Integer duration;

	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Note> notes = new HashSet<>();
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Absence> absences = new HashSet<>();
	
	public Subject() {
		super();
	}


	
	public Subject(Integer subjectId, Integer gradeId, String professorDni, String name, Integer duration) {
		super();
		this.subjectId = subjectId;
		this.gradeId = gradeId;
		this.professorDni = professorDni;
		this.name = name;
		this.duration = duration;
	}



	public Subject(Integer subjectId, GradeEdition grade, Integer gradeId, Professor professor, String professorDni,
			String name, Integer duration, Set<Note> notes, Set<Absence> absences) {
		super();
		this.subjectId = subjectId;
		this.grade = grade;
		this.gradeId = gradeId;
		this.professor = professor;
		this.professorDni = professorDni;
		this.name = name;
		this.duration = duration;
		this.notes = notes;
		this.absences = absences;
	}

	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public GradeEdition getGrade() {
		return grade;
	}
	public void setGrade(GradeEdition grade) {
		this.grade = grade;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
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
	public Set<Note> getNotes() {
		return notes;
	}
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}
	public Set<Absence> getAbsences() {
		return absences;
	}
	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", grade=" + grade + ", gradeId=" + gradeId + ", professor="
				+ professor + ", professorDni=" + professorDni + ", name=" + name + ", duration=" + duration
				+ ", notes=" + notes + ", absences=" + absences + "]";
	}

	
}
