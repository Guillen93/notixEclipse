package com.grupo5.reto2.student;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
public interface StudentService {

	Iterable<StudentServiceModel> findAllStudents() throws NotContentException;
	Iterable<StudentServiceModel> getStudentsBySubjectId(Integer subjectId) throws NotContentException;
	StudentServiceModel findByStudentDni(String studentDNI) throws NotContentException;
	Iterable<StudentServiceModel> getStudentsbyProfessorDni(String professorDNI) throws NotContentException;
	Iterable<PromotionServiceModel> getStudentsByGradeEdition(Integer GradeEditionId) throws NotContentException;
	StudentServiceModel createStudent(StudentPostRequest student) throws  ConflictException, NotContentException;
	StudentServiceModel updateStudent(String studentDNI,StudentPostRequest student) throws ConflictException, NotContentException;
	Integer deleteByStudentDni(String studentDNI);	
	
	
}
