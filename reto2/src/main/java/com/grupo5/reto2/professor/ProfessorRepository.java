package com.grupo5.reto2.professor;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
	
	Professor findByProfessorDni(String professorDni);
	
	@Transactional
	Integer deleteByProfessorDni(String professorDni);
}
