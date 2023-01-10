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
		
		return gradeService.findByGradeId(gradeId);	
	}
	
	@PostMapping("/grades")
	public ResponseEntity<Integer> createGrade(@RequestBody GradePostRequest gradePostRequest) {
		
		return gradeService.createGrade(gradePostRequest);
	}
	
	@PutMapping("/grades/{id}")
	public ResponseEntity<Integer> updateGrade(@PathVariable("id") Integer gradeId, @RequestBody GradePostRequest gradePostRequest) {
			
		return gradeService.updateGrade(gradeId, gradePostRequest);
	}
	
	
	@DeleteMapping("/grades/{id}")
	public ResponseEntity<Integer> deleteGradeById(@PathVariable("id") Integer gradeId){
		
		return gradeService.deleteByGradeId(gradeId);		
	}
}
