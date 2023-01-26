package com.grupo5.reto2.subject;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import jakarta.transaction.Transactional;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {

	Subject findBySubjectId(Integer subjectId);
	
	@Transactional
	Iterable<Subject> findByProfessorDni(String dni);
	
	@Transactional
	Iterable<Subject> findByGradeEdId(Integer gradeEditionId);
	
	Subject findByName(String name);
	
	@Transactional
	@Query(value="select * from subject where subject_id in (select subject_id from note where student_dni = :student_dni)",nativeQuery = true)
	Iterable<Subject> findSubjectByStudentDni(@Param("student_dni") String student_dni);
	
}