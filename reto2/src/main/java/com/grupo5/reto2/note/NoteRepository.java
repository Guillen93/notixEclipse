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
	//@Modifying
	Note findByStudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId);

	
	@Transactional
	@Modifying
	Note deleteByStudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId);

	
	//@Transactional
	//@Modifying
	//void updateBystudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId, NotePostRequest notePostRequest);
	
	
//	 @Query("SELECT * FROM note ")
//	 public List<Note> findAllNote();
//	 
//	
}
