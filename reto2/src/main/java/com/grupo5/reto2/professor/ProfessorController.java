package com.grupo5.reto2.professor;

import java.io.IOException;

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
public class ProfessorController {
	@Autowired
	ProfessorService professorService;

	@GetMapping("/professors")
	public ResponseEntity<Iterable<ProfessorResponse>> getProfessors() throws NotContentException, IOException {
		Iterable<ProfessorResponse> response = professorService.findAll();
		return new ResponseEntity<Iterable<ProfessorResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/professors/{professorDni}")
	public ResponseEntity<ProfessorResponse> getProfessorByDni(@PathVariable String professorDni)
			throws NotContentException, IOException {
		return new ResponseEntity<ProfessorResponse>(professorService.findByProfessorDni(professorDni), HttpStatus.OK);
	}

	@GetMapping("/professors/students/{studentDni}")
	public ResponseEntity<Iterable<ProfessorResponse>> getProfessorByStudentDni(@PathVariable String studentDni)
			throws NotContentException, IOException {

		Iterable<ProfessorResponse> response = professorService.getProfessorByStudentDni(studentDni);

		return new ResponseEntity<Iterable<ProfessorResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/professors/gradeEditionId/{gradeEditionId}")
	public ResponseEntity<ProfessorResponse> getTutorByGradeEditionId(@PathVariable Integer gradeEditionId)
			throws NotContentException, IOException {

		return new ResponseEntity<ProfessorResponse>(professorService.findTutorByGradeEditionId(gradeEditionId),
				HttpStatus.OK);
	}

	@PostMapping("/professors/create")
	public ResponseEntity<ProfessorResponse> createProfessor(@Valid @RequestBody ProfessorRequest professorRequest)
			throws ConflictException, NotContentException, IOException {

		ProfessorResponse response = professorService.createProfessor(professorRequest);
		return new ResponseEntity<ProfessorResponse>(response, HttpStatus.CREATED);

	}

	@PutMapping("/professors/{professorDni}")
	public ResponseEntity<ProfessorResponse> updateProfessor(@PathVariable String professorDni,
			@RequestBody ProfessorRequest professorRequest) throws NotContentException {

		ProfessorResponse response = professorService.updateProfessor(professorDni, professorRequest);

		return new ResponseEntity<ProfessorResponse>(response, HttpStatus.OK);

	}

	@DeleteMapping("/professors/{professorDni}")
	public ResponseEntity<Integer> deleteProfessor(@PathVariable String professorDni) throws NotContentException {

		Integer response = professorService.deleteByProfessorDni(professorDni);

		if (response == 0) {
			throw new NotContentException("No existe el estudiante");
		} else {
			return new ResponseEntity<Integer>(HttpStatus.OK);
		}

	}

}
