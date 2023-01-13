package com.grupo5.reto2.subject;

import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {

	Subject findBySubjectId(Integer subjectId);
	
	Subject findByName(String name);
	
}