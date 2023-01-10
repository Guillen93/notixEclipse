package com.grupo5.reto2.student;


import org.springframework.http.ResponseEntity;

public interface StudentService {

	ResponseEntity<Iterable<StudentServiceModel>> findAllStudents();
	ResponseEntity<StudentServiceModel> findByStudentDni(String studentDNI);
	ResponseEntity<Integer> createStudent(StudentPostRequest student);
	ResponseEntity<Integer> updateStudent(String studentDNI,StudentPostRequest student);
	ResponseEntity<Integer> deleteByStudentDni(String studentDNI);	
	
	
}
