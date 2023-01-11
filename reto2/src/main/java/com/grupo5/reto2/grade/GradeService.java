package com.grupo5.reto2.grade;

import java.util.List;


public interface GradeService {

	List<GradeServiceModel> findAllGrades();
	GradeServiceModel findByGradeId(Integer gradeId);
	Boolean createGrade(GradePostRequest grade);
	Boolean updateGrade(Integer gradeId,GradePostRequest grade);
	Boolean deleteByGradeId(Integer gradeId);
}
