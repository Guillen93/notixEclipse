package com.grupo5.reto2.professor;

public interface ProfessorService {
	
	Iterable<Professor> findAll();
	ProfessorResponse findByProfessorDni(String professorDni);
	Boolean createProfessor(ProfessorRequest professorRequest);
	Boolean updateProfessor(String professorDni, ProfessorRequest professorRequest);
	Boolean deleteByProfessorDni(String professorDni);
}