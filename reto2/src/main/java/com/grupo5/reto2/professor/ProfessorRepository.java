package com.grupo5.reto2.professor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
	Optional<Professor> findByDni(String dni);
}
