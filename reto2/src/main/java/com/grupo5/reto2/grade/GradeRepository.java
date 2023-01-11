
package com.grupo5.reto2.grade;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface GradeRepository extends CrudRepository< Grade, Integer> {

	@Transactional
	@Modifying
	Integer deleteByGradeId(Integer gradeId);
	
	@Transactional
	Grade findByName(String gradeName);
}

