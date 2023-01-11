package com.grupo5.reto2.gradeEdition;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface GradeEditionService {

	Iterable<GradeEditionServiceModel> findAllGradeEditions() throws NotContentException;
	GradeEditionServiceModel findByGradeEditionId(Integer gradeEditionId) throws NotContentException;
	GradeEditionServiceModel createGradeEdition(GradeEditionPostRequest gradeEditionPostRequest) throws ConflictException;
	GradeEditionServiceModel updateGradeEdition(Integer gradeEditionId,GradeEditionPostRequest gradeEditionPostRequest) throws NotContentException;
	Boolean deleteById(Integer gradeEditionId) throws NotContentException; 

}
