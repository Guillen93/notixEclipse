package com.grupo5.reto2.student;

import java.io.IOException;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
public interface StudentService {

	Iterable<StudentServiceModel> findAllStudents() throws NotContentException, IOException;
	Iterable<StudentServiceModel> getStudentsBySubjectId(Integer subjectId) throws NotContentException, IOException;
	StudentServiceModel findByStudentDni(String studentDNI) throws NotContentException, IOException;
	Iterable<StudentServiceModel> getStudentsbyProfessorDni(String professorDNI) throws NotContentException, IOException;
	Iterable<StudentServiceModel> findStudentBySubjectIdAndProfessorDni(Integer Subject_id,String professorDNI) throws NotContentException, IOException;
	Iterable<StudentServiceModel> getStudentsByGradeEdition(Integer GradeEditionId) throws NotContentException, IOException;
	StudentServiceModel createStudent(StudentPostRequest student) throws  ConflictException, NotContentException, IOException;
	Integer createPromotion(PromotionPostRequest promotionPostRequest) throws  ConflictException, NotContentException;
	StudentServiceModel updateStudent(String studentDNI,StudentPostRequest student) throws ConflictException, NotContentException;
	Integer deleteByStudentDni(String studentDNI);	
	
	
}
