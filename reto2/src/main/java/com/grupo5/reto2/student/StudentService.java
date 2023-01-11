package com.grupo5.reto2.student;


public interface StudentService {

	Iterable<StudentServiceModel> findAllStudents() throws NotContentException;
	StudentServiceModel findByStudentDni(String studentDNI) throws NotContentException;
	StudentServiceModel createStudent(StudentPostRequest student) throws  ConflictException, NotContentException;
	StudentServiceModel updateStudent(String studentDNI,StudentPostRequest student) throws ConflictException, NotContentException;
	Integer deleteByStudentDni(String studentDNI);	
	
	
}
