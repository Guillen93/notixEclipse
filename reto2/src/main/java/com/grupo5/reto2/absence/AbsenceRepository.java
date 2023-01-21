package com.grupo5.reto2.absence;

import java.sql.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;


@Repository
public interface AbsenceRepository extends CrudRepository<Absence,AbsenceId> {

	
	@Transactional
	Iterable<Absence> findByStudentDni(@Param("StudentDni") String studentDNI);
	
	@Transactional
	Absence findByStudentDniAndSubjectId(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId);
	
	@Transactional
	Absence findByStudentDniAndSubjectIdAndFoul(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId,@Param("Date") Date date);

	@Transactional
	Iterable<Absence> findByStudentDniAndJustified(@Param("StudentDni") String studentDNI,@Param("Justified") Boolean justificado);

	
	@Transactional
	@Modifying
	Integer deleteByStudentDniAndSubjectIdAndFoul(@Param("StudentDni") String studentDNI,@Param("SubjectId") Integer subjectId,@Param("Date") Date date);

}
