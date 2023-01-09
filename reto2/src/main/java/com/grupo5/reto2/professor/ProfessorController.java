package com.grupo5.reto2.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/professors")
	public ResponseEntity<Iterable<Professor>> getProfessors() {
		return new ResponseEntity <Iterable<Professor>>(professorService.findAll(), HttpStatus.OK);
	}

}
