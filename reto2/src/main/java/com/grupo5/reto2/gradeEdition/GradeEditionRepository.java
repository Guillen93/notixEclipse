
package com.grupo5.reto2.gradeEdition;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface GradeEditionRepository extends CrudRepository<GradeEdition, Integer> {

	@Transactional
	GradeEdition findByGradeIdAndTutorDni(Integer gradeId, String tutorDni);
	
	
	@Transactional
	GradeEdition findByGradeEditionId(Integer gradeEdId);
	
	@Transactional
	@Query(value="select * from grade_edition where grade_edition_id in (select max(grade_edition_id) from grade_edition);",nativeQuery = true)
	GradeEdition findLastgradeEdition();
	
	@Transactional
	GradeEdition findByTutorDni(String gradeEdId);
	
	
	@Transactional
	Iterable<GradeEdition> findGradeEditionByPromotionsStudentDni(String studentDni);
	

	
	
	
	
	
}

