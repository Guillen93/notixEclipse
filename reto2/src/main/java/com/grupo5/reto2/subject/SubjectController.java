package com.grupo5.reto2.subject;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("api")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@GetMapping("/subjects")
	public ResponseEntity<Iterable<SubjectServiceModel>> getSubject() throws NotContentException {

		Iterable<SubjectServiceModel> response  = subjectService.findAllSubject();
		return new ResponseEntity<Iterable<SubjectServiceModel>>(response, HttpStatus.OK);
		
	}

	@GetMapping("/subjects/{subjetId}")
	public ResponseEntity<SubjectServiceModel> getSubjectById(@PathVariable Integer subjetId) throws NotContentException {

		SubjectServiceModel response = subjectService.findSubjectById(subjetId);

		return new ResponseEntity<SubjectServiceModel>(response, HttpStatus.OK);
	}
	
	@GetMapping("/subjects/student/{studentDni}")
	public ResponseEntity<Iterable<SubjectServiceModel>> getSubjectByStudentDni(@PathVariable String studentDni) throws NotContentException {

		Iterable<SubjectServiceModel> response = subjectService.findSubjectsByStudentDni(studentDni);

		return new ResponseEntity<Iterable<SubjectServiceModel>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/subjects/gradeEditionId/{gradeEditionId}")
	public ResponseEntity<Iterable<SubjectServiceModel>> getSubjectByGradeEditionId(@PathVariable Integer gradeEditionId) throws NotContentException {

		Iterable<SubjectServiceModel> response = subjectService.findSubjectsByGradeEditionId(gradeEditionId);
		
		return new ResponseEntity<Iterable<SubjectServiceModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/subjects/professor/{professorDni}")
	public ResponseEntity<Iterable<SubjectServiceModel>> getSubjectByProfessorDni(@PathVariable String professorDni) throws NotContentException {

		Iterable<SubjectServiceModel> response = subjectService.findSubjectsByProfessorDni(professorDni);

		return new ResponseEntity<Iterable<SubjectServiceModel>>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/subjects")
	public ResponseEntity<SubjectServiceModel> createSubject(@Valid @RequestBody SubjectPostRequest subjectPostRequest) throws ConflictException, NotContentException {

		SubjectServiceModel response = subjectService.createSubject(subjectPostRequest);

		return new ResponseEntity<SubjectServiceModel>(response, HttpStatus.CREATED);
	}

	@PutMapping("/subjects/{subjectId}")
	public ResponseEntity<SubjectServiceModel> updateSubject(@PathVariable Integer subjectId,
			@RequestBody SubjectPostRequest subjectPostRequest) throws ConflictException, NotContentException {
		
		SubjectServiceModel response = subjectService.updateSubject(subjectId,subjectPostRequest);

		return new ResponseEntity<SubjectServiceModel>(response, HttpStatus.OK);
	}

	@DeleteMapping("/subjects/{subjectId}")
	public ResponseEntity<Integer> deleteSubject(@PathVariable Integer subjectId) throws NotContentException {

		subjectService.deleteSubject(subjectId);

		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

}