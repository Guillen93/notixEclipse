package com.grupo5.reto2.gradeEdition;

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
public class GradeEditionController {

	@Autowired
	GradeEditionService gradeEditionService;
	
	@GetMapping("/gradeEditions")
	public ResponseEntity<Iterable<GradeEditionServiceModel>> getGradeEditions() {
		return new ResponseEntity <Iterable<GradeEditionServiceModel>> (gradeEditionService.findAllGradeEditions(), HttpStatus.OK);
	}
	
	@GetMapping("/gradeEditions/{id}")
	public ResponseEntity<GradeEditionServiceModel> getGradeEditionById(@PathVariable("id") Integer gradeEditionId) {
		return new ResponseEntity <GradeEditionServiceModel> (gradeEditionService.findByGradeEditionId(gradeEditionId),HttpStatus.OK);	
	}
	
	@PostMapping("/gradeEditions")
	public ResponseEntity<Integer> createGradeEdition(@RequestBody GradeEditionPostRequest gradeEditionPostRequest) {
		Boolean response = gradeEditionService.createGradeEdition(gradeEditionPostRequest);
		if(!response) {
			return new ResponseEntity<Integer> (HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Integer> (HttpStatus.OK);
		}
	}
	
	@PutMapping("/gradeEditions/{id}")
	public ResponseEntity<Integer> updateGradeEdition(@PathVariable("id") Integer gradeEditionId, @RequestBody GradeEditionPostRequest gradeEditionPostRequest) {
		Boolean response = gradeEditionService.updateGradeEdition(gradeEditionId, gradeEditionPostRequest);
		
		if(!response) {
			return new ResponseEntity<Integer> (HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Integer> (HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/gradeEditions/{id}")
	public ResponseEntity<Integer> deleteGradeEditionById(@PathVariable("id") Integer gradeEditionId){

		Boolean response = gradeEditionService.deleteByGradeEditionId(gradeEditionId);
		
		if(!response) {
			return new ResponseEntity<Integer> (HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Integer> (HttpStatus.OK);
		}		
	}
}
