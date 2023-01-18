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

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.student.PromotionServiceModel;
import com.grupo5.reto2.student.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class GradeEditionController {

	@Autowired
	GradeEditionService gradeEditionService;
	@Autowired
	StudentService studentService;

	@GetMapping("/gradeEditions")
	public ResponseEntity<Iterable<GradeEditionServiceModel>> getGradeEditions() throws NotContentException {
		return new ResponseEntity<Iterable<GradeEditionServiceModel>>(gradeEditionService.findAllGradeEditions(),
				HttpStatus.OK);
	}

	@GetMapping("/gradeEditions/{id}")
	public ResponseEntity<GradeEditionServiceModel> getGradeEditionById(@PathVariable("id") Integer gradeEditionId)
			throws NotContentException {
		return new ResponseEntity<GradeEditionServiceModel>(gradeEditionService.findByGradeEditionId(gradeEditionId),
				HttpStatus.OK);
	}

	@GetMapping("/gradeEditions/{id}/student")
	public ResponseEntity<Iterable<PromotionServiceModel>> getStudentsByGradeEdition(
			@PathVariable("id") Integer gradeEditionId) throws NotContentException {

		return new ResponseEntity<Iterable<PromotionServiceModel>>(
				studentService.getStudentsByGradeEdition(gradeEditionId), HttpStatus.OK);
	}

	@PostMapping("/gradeEditions")
	public ResponseEntity<GradeEditionServiceModel> createGradeEdition(
			@Valid @RequestBody GradeEditionPostRequest gradeEditionPostRequest) throws ConflictException {
		GradeEditionServiceModel response = gradeEditionService.createGradeEdition(gradeEditionPostRequest);
		return new ResponseEntity<GradeEditionServiceModel>(response, HttpStatus.CREATED);
	}

	@PutMapping("/gradeEditions/{id}")
	public ResponseEntity<GradeEditionServiceModel> updateGradeEdition(@PathVariable("id") Integer gradeEditionId,
			@RequestBody GradeEditionPostRequest gradeEditionPostRequest) throws NotContentException {
		GradeEditionServiceModel response = gradeEditionService.updateGradeEdition(gradeEditionId,
				gradeEditionPostRequest);

		return new ResponseEntity<GradeEditionServiceModel>(response, HttpStatus.OK);
	}

	@DeleteMapping("/gradeEditions/{id}")
	public ResponseEntity<Integer> deleteGradeEditionById(@PathVariable("id") Integer gradeEditionId)
			throws NotContentException {

		gradeEditionService.deleteById(gradeEditionId);

		return new ResponseEntity<Integer>(HttpStatus.OK);

	}
}
