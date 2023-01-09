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


@RestController
@RequestMapping("api")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<Iterable<StudentServiceModel>> getStudent() {
		return new ResponseEntity<Iterable<StudentServiceModel>>(studentService.findAllStudents(), HttpStatus.OK);
	}

	@GetMapping("/students/{studentDNI}")
	public ResponseEntity<StudentServiceModel> getStudentById(@PathVariable String studentDNI) {
		return new ResponseEntity<StudentServiceModel>(studentService.findByStudentDni(studentDNI), HttpStatus.OK);
	}

	@PostMapping("/students")
	public ResponseEntity<Integer> createStudents(@RequestBody StudentPostRequest studentPostRequest ) {
		return studentService.createStudent(studentPostRequest);
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
