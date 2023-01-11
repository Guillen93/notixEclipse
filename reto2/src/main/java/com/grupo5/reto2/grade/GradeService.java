package com.grupo5.reto2.grade;

import java.util.List;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;


public interface GradeService {

	List<GradeServiceModel> findAllGrades() throws NotContentException;
	GradeServiceModel findByGradeId(Integer gradeId) throws NotContentException;
	GradeServiceModel createGrade(GradePostRequest grade) throws ConflictException;
	GradeServiceModel updateGrade(Integer gradeId,GradePostRequest grade) throws NotContentException;
	Integer deleteByGradeId(Integer gradeId);
}
