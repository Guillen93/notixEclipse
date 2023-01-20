package com.grupo5.reto2.professor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
	
	Professor findByProfessorDni(String professorDni);
	Boolean existsByProfessorDni(String professorDni);
	
	@Transactional
	@Modifying
	Integer deleteByProfessorDni(String professorDni);
}
