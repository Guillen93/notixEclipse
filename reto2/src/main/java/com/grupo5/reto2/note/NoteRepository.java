package com.grupo5.reto2.note;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface NoteRepository extends CrudRepository<Note,NoteId> {

	
	@Transactional
	Note findByStudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId);
	
	@Transactional
	Iterable<Note> findBySubjectId(@Param("SubjectId") Integer subjectId);

	
	@Transactional
	Iterable<Note> findByStudentDni(@Param("StudentDni") String studentDNI);
	
	@Transactional
	@Modifying
	Integer deleteByStudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId);

	
	@Query(value="select * from note where subject_id in ( select subject_id from subject where professor_dni = :professor_dni)",nativeQuery = true)
	Iterable<Note> getNotesbyProfessorDni(@Param("professor_dni") String professor_dni );
	
	
	
	
	
}