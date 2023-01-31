package com.grupo5.reto2.absence;

import java.sql.Date;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface AbsenceService {

	Iterable<AbsenceServiceModel> getAllAbsences() throws NotContentException;
	Iterable<AbsenceServiceModel> getAllAbsencesByStudent(String studentDni) throws NotContentException;
	Iterable<AbsenceServiceModel> getAbsencesByStudentDniAndJustified(String studentDni) throws NotContentException;
	Iterable<AbsenceServiceModel> getAbsencesByStudentDniAndSubjectId(String StudentDni, Integer subjectId) throws NotContentException;
	AbsenceServiceModel createAbsence(AbsencePostRequest absencePostRequest) throws ConflictException, NotContentException;
	AbsenceServiceModel updateAbsence(String studentDni, Integer subjectId ,String date ,AbsencePostRequest absencePostRequest) throws NotContentException;
	Integer deleteAbsence(String StudentDni, Integer subjectId ,Date date);
}
