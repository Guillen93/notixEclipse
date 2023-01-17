package com.grupo5.reto2.student;

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

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<Iterable<StudentServiceModel>> getStudent() throws NotContentException {

		Iterable<StudentServiceModel> response = studentService.findAllStudents();
		return new ResponseEntity<Iterable<StudentServiceModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/students/{studentDNI}")
	public ResponseEntity<StudentServiceModel> getStudentById(@PathVariable String studentDNI)
			throws NotContentException {

		StudentServiceModel response = studentService.findByStudentDni(studentDNI);
		return new ResponseEntity<StudentServiceModel>(response, HttpStatus.OK);

	}
	
	

	@PostMapping("/students")
	public ResponseEntity<StudentServiceModel> createStudents(@Valid @RequestBody StudentPostRequest studentPostRequest)
			throws ConflictException, NotContentException {
		StudentServiceModel response = studentService.createStudent(studentPostRequest);
		return new ResponseEntity<StudentServiceModel>(response, HttpStatus.CREATED);
	}

	@PutMapping("/students/{studentDNI}")
	public ResponseEntity<StudentServiceModel> updateStudents(@PathVariable String studentDNI,
			@RequestBody StudentPostRequest studentPostRequest) throws ConflictException, NotContentException {

		StudentServiceModel response = studentService.updateStudent(studentDNI, studentPostRequest);

		return new ResponseEntity<StudentServiceModel>(response, HttpStatus.OK);
	}

	@DeleteMapping("/students/{studentDNI}")
	public ResponseEntity<Integer> deleteStudents(@PathVariable String studentDNI) throws NotContentException {

		Integer response = studentService.deleteByStudentDni(studentDNI);

		if (response == 0) {
			throw new NotContentException("No existe el estudiante");
		} else {
			return new ResponseEntity<Integer>(HttpStatus.OK);
		}
	}

}
