package com.grupo5.reto2.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public ResponseEntity<Iterable<StudentServiceModel>> findAllStudents() {
		Iterable<Student> students = studentRepository.findAll();

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		for (Student student : students) {
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate(), student.getNationality(), student.getEmail(), student.getPhone(),
					student.getPhoto()));
		}
		return new ResponseEntity<Iterable<StudentServiceModel>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentServiceModel> findByStudentDni(String studentDNI) {
		Student student = studentRepository.findByStudentDni(studentDNI);

		if (student == null) {

			return new ResponseEntity<StudentServiceModel>(HttpStatus.NOT_FOUND);
		} else {
			StudentServiceModel response = new StudentServiceModel(student.getStudentDni(), student.getName(),
					student.getSurname(), student.getBornDate(), student.getNationality(), student.getEmail(),
					student.getPhone(), student.getPhoto());

			return new ResponseEntity<StudentServiceModel>(response, HttpStatus.OK);
		}

	}

	@Override
	public ResponseEntity<Integer> createStudent(StudentPostRequest studentPostRequest) {

		Student response = studentRepository.findByStudentDni(studentPostRequest.getStudentDni());

		if (response != null) {

			return new ResponseEntity<Integer>(HttpStatus.NOT_IMPLEMENTED);

		} else {

			response = new Student(studentPostRequest.getStudentDni(), studentPostRequest.getName(),
					studentPostRequest.getSurname(), studentPostRequest.getBornDate(),
					studentPostRequest.getNationality(), studentPostRequest.getEmail(), studentPostRequest.getPhone(),
					studentPostRequest.getPhoto());

			studentRepository.save(response);
			return new ResponseEntity<Integer>(HttpStatus.CREATED);

		}

	}

	@Override
	public ResponseEntity<Integer> updateStudent(String studentDNI, StudentPostRequest studentPostRequest) {

		Student response = studentRepository.findByStudentDni(studentDNI);

		if (response == null) {

			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);

		} else {

			if (studentPostRequest.getStudentDni() != null) {
				response.setStudentDni(studentPostRequest.getStudentDni());
			}
			if (studentPostRequest.getName() != null) {
				response.setName(studentPostRequest.getName());
			}
			if (studentPostRequest.getSurname() != null) {
				response.setSurname(studentPostRequest.getSurname());
			}
			if (studentPostRequest.getBornDate() != null) {
				response.setBornDate(studentPostRequest.getBornDate());
			}
			if (studentPostRequest.getNationality() != null) {
				response.setNationality(studentPostRequest.getNationality());
			}
			if (studentPostRequest.getEmail() != null) {
				response.setEmail(studentPostRequest.getEmail());
			}
			if (studentPostRequest.getPhone() != null) {
				response.setPhone(studentPostRequest.getPhone());
			}
			if (studentPostRequest.getPhoto() != null) {
				response.setPhoto(studentPostRequest.getPhoto());
			}

			studentRepository.save(response);

			return new ResponseEntity<Integer>(HttpStatus.OK);
		}

	}

	@Override
	public ResponseEntity<Integer> deleteByStudentDni(String studentDNI) {

		Integer response = studentRepository.deleteByStudentDni(studentDNI);
		
		if(response == 0) {
			return new ResponseEntity<Integer>(response, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Integer>(response, HttpStatus.OK);
		}
		
		
	}

}
