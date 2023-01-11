
package com.grupo5.reto2.gradeEdition;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface GradeEditionRepository extends CrudRepository< GradeEdition, Integer> {

	@Transactional
	GradeEdition findByGradeIdAndTutorDni(Integer gradeId, String tutorDni);
}

