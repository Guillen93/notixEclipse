package com.grupo5.reto2.gradeEdition;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grupo5.reto2.grade.Grade;
import com.grupo5.reto2.professor.Professor;
import com.grupo5.reto2.student.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="grade_edition")
public class GradeEdition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gradeEditionId;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "gradeId", foreignKey=@ForeignKey(name = "fk_gradeId"))
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Grade grade;
	@Column(name = "gradeId", updatable = false, insertable = false)
	private Integer gradeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "tutorDni", foreignKey=@ForeignKey(name = "fk_tutorDni"))
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Professor tutor;
	@Column(name = "tutorDni", updatable = false, insertable = false)
	private String tutorDni;
	
	@Column()
	private Date fecha;
	
	@ManyToMany(mappedBy = "promotions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Student> promotions = new HashSet<>();
	
	public GradeEdition() {
		super();
	}
	
	public GradeEdition(Integer gradeEdId,  Integer gradeId, Professor tutor, String tutorDni, Date fecha) {
		super();
		this.gradeEditionId = gradeEdId;
		this.gradeId = gradeId;
		this.tutor = tutor;
		this.tutorDni = tutorDni;
		this.fecha = fecha;
	}


	public GradeEdition(Integer gradeEdId, Grade grade, Integer gradeId, Professor tutor, String tutorDni, Date fecha) {
		super();
		this.gradeEditionId = gradeEdId;
		this.grade = grade;
		this.gradeId = gradeId;
		this.tutor = tutor;
		this.tutorDni = tutorDni;
		this.fecha = fecha;
	}

	public GradeEdition(Integer gradeEdId, Grade grade, Integer gradeId, Professor tutor, String tutorDni, Date fecha,
			Set<Student> promotions) {
		super();
		this.gradeEditionId = gradeEdId;
		this.grade = grade;
		this.gradeId = gradeId;
		this.tutor = tutor;
		this.tutorDni = tutorDni;
		this.fecha = fecha;
		this.promotions = promotions;
	}

	public GradeEdition(Integer gradeEdId, Integer gradeId, String tutorDni, Date fecha) {
		super();
		this.gradeEditionId = gradeEdId;
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
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public Professor getTutor() {
		return tutor;
	}
	public void setTutor(Professor tutor) {
		this.tutor = tutor;
	}
	public String getTutorDni() {
		return tutorDni;
	}
	public void setTutorDni(String tutorDni) {
		this.tutorDni = tutorDni;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Set<Student> getPromotions() {
		return promotions;
	}
	public void setPromotions(Set<Student> promotions) {
		this.promotions = promotions;
	}

	@Override
	public String toString() {
		return "GradeEdition [gradeEdId=" + gradeEditionId + ", grade=" + grade + ", gradeId=" + gradeId + ", tutor=" + tutor
				+ ", tutorDni=" + tutorDni + ", fecha=" + fecha + ", promotions=" + promotions + "]";
	}


}
