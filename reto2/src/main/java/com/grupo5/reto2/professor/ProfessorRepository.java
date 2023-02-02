package com.grupo5.reto2.professor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
	
	Professor findByProfessorDni(String professorDni);
	Boolean existsByProfessorDni(String professorDni);
	
	@Transactional
	@Modifying
	Integer deleteByProfessorDni(String professorDni);
	
	@Transactional
	@Query(value="select * from professor where professor_dni in (select tutor_dni from grade_edition where grade_edition_id = :grade_edition_id );",nativeQuery = true)
	Professor findProfessorbyGradeEditionId(@Param("grade_edition_id")Integer grade_edition_id);	
	
	@Transactional
	@Query(value="select * from professor where professor_dni in (select professor_dni from subject where subject_id in (select subject_id from note where student_dni = :student_dni ));",nativeQuery = true)
	Iterable<Professor> findProfessorsByStudentDni(@Param("student_dni")String student_dni);	
	
}
