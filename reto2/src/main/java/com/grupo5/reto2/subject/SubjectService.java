package com.grupo5.reto2.subject;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface SubjectService {
	Iterable<SubjectServiceModel> findAllSubject() throws NotContentException;
	SubjectServiceModel findSubjectById(Integer subjetId) throws NotContentException;
	SubjectServiceModel createSubject(SubjectPostRequest subjectPostRequest) throws  ConflictException, NotContentException;
	SubjectServiceModel uupdateSubject(Integer subjectId,SubjectPostRequest subjectPostRequest) throws ConflictException, NotContentException;
	Integer deleteSubject(Integer subjectId);	
}
