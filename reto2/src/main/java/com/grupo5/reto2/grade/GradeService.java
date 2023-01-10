package com.grupo5.reto2.grade;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface GradeService {

	List<GradeServiceModel> findAllGrades();
	ResponseEntity<GradeServiceModel> findByGradeId(Integer gradeId);
	ResponseEntity<Integer> createGrade(GradePostRequest grade);
	ResponseEntity<Integer> updateGrade(Integer gradeId,GradePostRequest grade);
	ResponseEntity<Integer> deleteByGradeId(Integer gradeId);	
}
