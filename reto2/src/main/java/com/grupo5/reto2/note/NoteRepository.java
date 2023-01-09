package com.grupo5.reto2.note;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface NoteRepository extends CrudRepository<Note,NoteId> {

	
	@Transactional
	Note findByStudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId);

	
	@Transactional
	List<Note> findByStudentDni(@Param("StudentDni") String studentDNI);

	
	@Transactional
	@Modifying
	Integer deleteByStudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId);

	
	//@Transactional
	//@Modifying
	//void updateBystudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId, NotePostRequest notePostRequest);
	
	
	
	
	
}
