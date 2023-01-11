package com.grupo5.reto2.gradeEdition;

import java.util.List;



public interface GradeEditionService {

	List<GradeEditionServiceModel> findAllGradeEditions();
	GradeEditionServiceModel findByGradeEditionId(Integer gradeEditionId);
	Boolean createGradeEdition(GradeEditionPostRequest gradeEditionPostRequest);
	Boolean updateGradeEdition(Integer gradeEditionId,GradeEditionPostRequest gradeEditionPostRequest);
	Boolean deleteByGradeEditionId(Integer gradeEditionId);

}
