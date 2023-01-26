package com.grupo5.reto2.professor;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface ProfessorService {
	
	Iterable<ProfessorResponse> findAll() throws NotContentException;
	ProfessorResponse findByProfessorDni(String professorDni) throws NotContentException;
	ProfessorResponse findTutorByGradeEditionId(Integer gradeEditionId) throws NotContentException;
	ProfessorResponse createProfessor(ProfessorRequest professorRequest) throws ConflictException, NotContentException;
	ProfessorResponse updateProfessor(String professorDni, ProfessorRequest professorRequest) throws  NotContentException;
	Integer deleteByProfessorDni(String professorDni);
	Iterable<ProfessorResponse> getProfessorByStudentDni(String studentDni) throws NotContentException;
}