package com.grupo5.reto2.grade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("api")
public class GradeController {

	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private GradeService gradeService;
	
	@GetMapping("/grades")
	public ResponseEntity<Iterable<GradeServiceModel>> getGrades() {
	
		return new ResponseEntity <Iterable<GradeServiceModel>> (gradeService.findAllGrades(), HttpStatus.OK);	
	}
	
	@GetMapping("/grades/{id}")
	public ResponseEntity<GradeServiceModel> getGradeById(@PathVariable("id") Integer gradeId) {
		
		return new ResponseEntity <GradeServiceModel> (gradeService.findByGradeId(gradeId),HttpStatus.OK);	
	}
	
	@PostMapping("/grades")
	public ResponseEntity<Grade> createGrade(@RequestBody GradePostRequest gradePostRequest) {
		Boolean response = gradeService.createGrade(gradePostRequest);
		if(response) {
			return new ResponseEntity <Grade> (HttpStatus.CREATED);
		} else {
			return new ResponseEntity <Grade> (HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/grades/{id}")
	public ResponseEntity<Integer> updateGrade(@PathVariable("id") Integer gradeId, @RequestBody GradePostRequest gradePostRequest) {
			
		Boolean response = gradeService.updateGrade(gradeId, gradePostRequest);
		
		if(!response) {
			return new ResponseEntity<Integer> (HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Integer> (HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/grades/{id}")
	public ResponseEntity<Integer> deleteGradeById(@PathVariable("id") Integer gradeId){
		
		Boolean response = gradeService.deleteByGradeId(gradeId);
		
		if(!response) {
			return new ResponseEntity<Integer> (HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Integer> (HttpStatus.OK);
		}		
	}
}
