package com.grupo5.reto2.subject;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface SubjectService {
	Iterable<SubjectServiceModel> findAllSubject() throws NotContentException;
	Iterable<SubjectServiceModel> findSubjectsByStudentDni(String dni) throws NotContentException;
	Iterable<SubjectServiceModel> findSubjectsByGradeEditionId(Integer gradeEditionId) throws NotContentException;
	Iterable<SubjectServiceModel> findSubjectsByProfessorDni(String dni) throws NotContentException;
	SubjectServiceModel findSubjectById(Integer subjetId) throws NotContentException;
	SubjectServiceModel createSubject(SubjectPostRequest subjectPostRequest) throws  ConflictException, NotContentException;
	SubjectServiceModel updateSubject(Integer subjectId,SubjectPostRequest subjectPostRequest) throws ConflictException, NotContentException;
	Boolean deleteSubject(Integer subjectId) throws NotContentException;	
}
