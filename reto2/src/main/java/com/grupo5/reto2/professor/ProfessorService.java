package com.grupo5.reto2.professor;

import java.io.IOException;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface ProfessorService {
	
	Iterable<ProfessorResponse> findAll() throws NotContentException, IOException;
	ProfessorResponse findByProfessorDni(String professorDni) throws NotContentException, IOException;
	ProfessorResponse findTutorByGradeEditionId(Integer gradeEditionId) throws NotContentException, IOException;
	ProfessorResponse createProfessor(ProfessorRequest professorRequest) throws ConflictException, NotContentException, IOException;
	ProfessorResponse updateProfessor(String professorDni, ProfessorRequest professorRequest) throws  NotContentException;
	Integer deleteByProfessorDni(String professorDni);
	Iterable<ProfessorResponse> getProfessorByStudentDni(String studentDni) throws NotContentException, IOException;
}