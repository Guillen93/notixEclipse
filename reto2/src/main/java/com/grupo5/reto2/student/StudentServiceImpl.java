package com.grupo5.reto2.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	
	
	@Override
	public List<StudentServiceModel> findAllStudents() {
		Iterable<Student> students = studentRepository.findAll();

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		for (Student student : students) {
			response.add(new StudentServiceModel(student.getStudentDni(),
					student.getName(),
					student.getSurname(),
					student.getBornDate(),
					student.getNationality(),
					student.getEmail(),
					student.getPhone(),
					student.getPhoto()));
		}
		return response;
	}

	@Override
	public StudentServiceModel findByStudentDni(String studentDNI) {
		Student student = studentRepository.findByStudentDni(studentDNI);

		StudentServiceModel response = new StudentServiceModel(
				student.getStudentDni(),
				student.getName(),
				student.getSurname(),
				student.getBornDate(),
				student.getNationality(),
				student.getEmail(),
				student.getPhone(),
				student.getPhoto()
				);
		return response;
	}

	@Override
	public ResponseEntity<Integer> createStudent(StudentPostRequest studentPostRequest) {
		
		Student response = new Student(
				studentPostRequest.getStudentDni(),
				studentPostRequest.getName(),
				studentPostRequest.getSurname(),
				studentPostRequest.getBornDate(),
				studentPostRequest.getNationality(),
				studentPostRequest.getEmail(),
				studentPostRequest.getPhone(),
				studentPostRequest.getPhoto()
				);

		 studentRepository.save(response);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> updateStudent(StudentPostRequest studentPostRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Integer> deleteByStudentDni(String studentDNI) {
		// TODO Auto-generated method stub
		return null;
	}

}
