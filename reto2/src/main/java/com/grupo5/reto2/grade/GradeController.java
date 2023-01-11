package com.grupo5.reto2.grade;


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


@RestController
@RequestMapping("api")
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@GetMapping("/grades")
	public ResponseEntity<Iterable<GradeServiceModel>> getGrades() throws NotContentException {
	
		return new ResponseEntity <Iterable<GradeServiceModel>> (gradeService.findAllGrades(), HttpStatus.OK);	
	}
	
	@GetMapping("/grades/{id}")
	public ResponseEntity<GradeServiceModel> getGradeById(@PathVariable("id") Integer gradeId) throws NotContentException {
		
		return new ResponseEntity <GradeServiceModel> (gradeService.findByGradeId(gradeId),HttpStatus.OK);	
	}
	
	@PostMapping("/grades")
	public ResponseEntity<GradeServiceModel> createGrade(@RequestBody GradePostRequest gradePostRequest) throws ConflictException {
		GradeServiceModel response = gradeService.createGrade(gradePostRequest);
		return new ResponseEntity<GradeServiceModel>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/grades/{id}")
	public ResponseEntity<GradeServiceModel> updateGrade(@PathVariable("id") Integer gradeId, @RequestBody GradePostRequest gradePostRequest) throws NotContentException {
			
		GradeServiceModel response = gradeService.updateGrade(gradeId, gradePostRequest);
		
		return new ResponseEntity<GradeServiceModel> (response,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/grades/{id}")
	public ResponseEntity<Integer> deleteGradeById(@PathVariable("id") Integer gradeId) throws NotContentException{
		
		Integer response = gradeService.deleteByGradeId(gradeId);
		if(response == 0) {
			throw new NotContentException("No existe el grado");
		} else {
			return new ResponseEntity<Integer> (HttpStatus.OK);
		}		
	}
}
