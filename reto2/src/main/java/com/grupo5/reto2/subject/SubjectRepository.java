package com.grupo5.reto2.subject;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {

	Subject findBySubjectId(Integer subjectId);
	
	@Transactional
	Iterable<Subject> findByProfessorDni(String dni);
	
	Subject findByName(String name);
	
}