package com.grupo5.reto2.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public ResponseEntity<Iterable<StudentServiceModel>> getStudent() {

		Iterable<Student> students = studentRepository.findAll();

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		for (Student student : students) {
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate(), student.getNationality(), student.getEmail(), student.getPhone(),
					student.getPhoto()));
		}
		return new ResponseEntity<Iterable<StudentServiceModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/students/{studentDNI}")
	public ResponseEntity<StudentServiceModel> getStudentById(@PathVariable String studentDNI) {

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

		return new ResponseEntity<StudentServiceModel>(response, HttpStatus.OK);
	}

	@PostMapping("/students")
	public ResponseEntity<Student> createStudents(@RequestBody StudentPostRequest studentPostRequest ) {

		

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
		
		return new ResponseEntity<Student>(response, HttpStatus.OK);
	}
	
	@PutMapping("/students/{studentDNI}")
	public ResponseEntity<Student> updateStudents(@PathVariable String studentDNI,@RequestBody StudentPostRequest studentPostRequest ) {


		Student student = studentRepository.findByStudentDni(studentDNI);
		
		if(student == null) {
			return new ResponseEntity<Student>(student, HttpStatus.NOT_FOUND);
			
		}else {
			Student response = new Student(
					studentDNI,
					studentPostRequest.getName(),
					studentPostRequest.getSurname(),
					studentPostRequest.getBornDate(),
					studentPostRequest.getNationality(),
					studentPostRequest.getEmail(),
					studentPostRequest.getPhone(),
					studentPostRequest.getPhoto()
					);

			 studentRepository.save(response);
			
			return new ResponseEntity<Student>(response, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/students/{studentDNI}")
	public ResponseEntity<Integer> deleteStudents(@PathVariable String studentDNI ) {

		return new ResponseEntity<Integer>(studentRepository.deleteByStudentDni(studentDNI),HttpStatus.OK);

	}
	
}
