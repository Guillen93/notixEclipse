package com.grupo5.reto2.note;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;


public interface NoteRepository extends CrudRepository<Note,Integer> {

	@Transactional
	@Modifying
	Integer deleteByStudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId);

	
	@Transactional
	@Modifying
	void updateBystudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId, NotePostRequest notePostRequest);
	
}
