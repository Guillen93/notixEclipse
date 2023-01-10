package com.grupo5.reto2.professor;

import org.springframework.http.ResponseEntity;

public interface ProfessorService {
	
	Iterable<Professor> findAll();
	ProfessorResponse findByProfessorDni(String professorDni);
	ResponseEntity<Integer> createProfessor(ProfessorRequest professorRequest);
	ResponseEntity<Integer> updateProfessor(String professorDni, ProfessorRequest professorRequest);
	ResponseEntity<Integer> deleteByProfessorDni(String professorDni);
}