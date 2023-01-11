package com.grupo5.reto2.professor;

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
public class ProfessorController {
	@Autowired
	ProfessorService professorService;
	
	@GetMapping("/professors")
	public ResponseEntity<Iterable<Professor>> getProfessors() {
		return new ResponseEntity <Iterable<Professor>>(professorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/professors/{professorDni}")
	public ResponseEntity<ProfessorResponse> getProfessorByDni(@PathVariable String professorDni) {
		return new ResponseEntity<ProfessorResponse>(professorService.findByProfessorDni(professorDni), HttpStatus.OK);
	}
	
	@PostMapping("/professors")
	public ResponseEntity<Integer> createProfessor(@RequestBody ProfessorRequest professorRequest) {
		
		Boolean response = professorService.createProfessor(professorRequest);
		
		if (response == true) {
			return new ResponseEntity<Integer>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Integer>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/professors/{professorDni}")
	public ResponseEntity<Integer> updateProfessor(@PathVariable String professorDni,
			@RequestBody ProfessorRequest professorRequest) {
		
		Boolean response = professorService.updateProfessor(professorDni, professorRequest);
		
		if (response == true) {
			return new ResponseEntity<Integer>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(HttpStatus.NOT_MODIFIED);
		}		
	}
	
	@DeleteMapping("/professors/{professorDni}")
	public ResponseEntity<Integer> deleteProfessor(@PathVariable String professorDni) {
		
		Boolean response = professorService.deleteByProfessorDni(professorDni);
		
		if (response == true) {
			return new ResponseEntity<Integer>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(HttpStatus.CONFLICT);
		}
	}

}
