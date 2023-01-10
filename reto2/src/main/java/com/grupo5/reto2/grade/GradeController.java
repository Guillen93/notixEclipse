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
	
	@GetMapping("/grades")
	public ResponseEntity<Iterable<GradeServiceModel>> getEmployees() {
		Iterable<Grade> grades = gradeRepository.findAll();
		
		List<GradeServiceModel> response = new ArrayList<GradeServiceModel>();
		
		for (Grade grade : grades) {
			response.add(
					new GradeServiceModel(
							grade.getGradeId(),
							grade.getName(),
							grade.getLanguage()
							)
					 );
		}
		return new ResponseEntity <Iterable<GradeServiceModel>> (response, HttpStatus.OK);	
	}
	
	@GetMapping("/grades/{id}")
public ResponseEntity<GradeServiceModel> getEmployeeById(@PathVariable("id") Integer id) {
		
		Grade grade = gradeRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Grado no encontrado")
						);
		
		GradeServiceModel response = new GradeServiceModel(
				grade.getGradeId(),
				grade.getName(),
				grade.getLanguage()
				);
		return new ResponseEntity <GradeServiceModel> (response, HttpStatus.OK);	
	}
	
	@PostMapping("/grades")
	public ResponseEntity<GradeServiceModel> createGrade(@RequestBody GradePostRequest gradePostRequest) {

		Grade grade = new Grade(
				gradePostRequest.getGradeId(),
				gradePostRequest.getName(),
				gradePostRequest.getLanguage()
				);
		grade = gradeRepository.save(grade);
		
		GradeServiceModel response = new GradeServiceModel(
				grade.getGradeId(),
				grade.getName(),
				grade.getLanguage()
				);
		
		return new ResponseEntity<GradeServiceModel>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/grades/{id}")
	public ResponseEntity<GradeServiceModel> updateGrade(@PathVariable("id") Integer id, @RequestBody GradePostRequest gradePostRequest) {

		Boolean gradeAlreadyExists = gradeRepository.existsById(id);
		
		Grade grade = new Grade(
				id,
				gradePostRequest.getName(),
				gradePostRequest.getLanguage()
				);
		
		if(!gradeAlreadyExists) {
			return new ResponseEntity<GradeServiceModel>(HttpStatus.CONFLICT);
		} else {
			if(gradePostRequest.getName() != null && gradePostRequest.getName() != "") {
				grade.setName(gradePostRequest.getName());
			}
			if(gradePostRequest.getLanguage() != null && gradePostRequest.getLanguage() != "") {
				grade.setLanguage(gradePostRequest.getLanguage());
			}
			grade = gradeRepository.save(grade);
			
			GradeServiceModel response = new GradeServiceModel(
					grade.getGradeId(),
					grade.getName(),
					grade.getLanguage()
					);
			
			return new ResponseEntity<GradeServiceModel>(response, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/grades/{id}")
	public ResponseEntity<Integer> deleteDepartmentById(@PathVariable("id") Integer id){
		try {
			gradeRepository.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Grado no encontrado");
		}
				
	}
}
