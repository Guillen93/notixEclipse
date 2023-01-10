package com.grupo5.reto2.gradeEdition;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;




@RestController
@RequestMapping("api")
public class GradeEditionController {

	@Autowired
	private GradeEditionRepository gradeEditionRepository;
	
	@GetMapping("/gradeEditions")
	public ResponseEntity<Iterable<GradeEditionServiceModel>> getGradeEditions() {
		Iterable<GradeEdition> gradeEditions = gradeEditionRepository.findAll();
		
		List<GradeEditionServiceModel> response = new ArrayList<GradeEditionServiceModel>();
		
		for (GradeEdition gradeEdition : gradeEditions) {
			response.add(
					new GradeEditionServiceModel(
							gradeEdition.getGradeEdId(),
							gradeEdition.getGradeId(),
							gradeEdition.getTutorDni(),
							gradeEdition.getFecha()
							)
					 );
		}
		return new ResponseEntity <Iterable<GradeEditionServiceModel>> (response, HttpStatus.OK);	
	}
	
	@GetMapping("/gradeEditions/{id}")
	public ResponseEntity<GradeEditionServiceModel> getGradeEditionById(@PathVariable("id") Integer id) {
		
		GradeEdition gradeEdition = gradeEditionRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Edicion de grado no encontrado")
						);
		
		
		
		GradeEditionServiceModel response = new GradeEditionServiceModel(
				gradeEdition.getGradeEdId(),
				gradeEdition.getGradeId(),
				gradeEdition.getTutorDni(),
				gradeEdition.getFecha()
				);
		return new ResponseEntity <GradeEditionServiceModel> (response, HttpStatus.OK);	
	}
	
	@PostMapping("/gradeEditions")
	public ResponseEntity<GradeEditionServiceModel> createGradeEdition(@RequestBody GradeEditionPostRequest gradeEditionPostRequest) {

		GradeEdition gradeEdition = new GradeEdition(
				gradeEditionPostRequest.getGradeEdId(),
				gradeEditionPostRequest.getGradeId(),
				gradeEditionPostRequest.getTutorDni(),
				gradeEditionPostRequest.getFecha()
				);
		gradeEdition = gradeEditionRepository.save(gradeEdition);
		
		GradeEditionServiceModel response = new GradeEditionServiceModel(
				gradeEdition.getGradeEdId(),
				gradeEdition.getGradeId(),
				gradeEdition.getTutorDni(),
				gradeEdition.getFecha()
				);
		
		return new ResponseEntity<GradeEditionServiceModel>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/gradeEditions/{id}")
	public ResponseEntity<GradeEditionServiceModel> updateGradeEdition(@PathVariable("id") Integer gradeEditionId, @RequestBody GradeEditionPostRequest gradeEditionPostRequest) {

		Boolean gradeEditionAlreadyExists = gradeEditionRepository.existsById(gradeEditionId);
		
		GradeEdition gradeEdition = new GradeEdition(
				gradeEditionId,
				gradeEditionPostRequest.getGradeId(),
				gradeEditionPostRequest.getTutorDni(),
				gradeEditionPostRequest.getFecha()
				);
		
		if(!gradeEditionAlreadyExists) {
			return new ResponseEntity<GradeEditionServiceModel>(HttpStatus.CONFLICT);
		} else {
			if(gradeEditionPostRequest.getGradeId() != null) {
				gradeEdition.setGradeId(gradeEditionPostRequest.getGradeId());
			}
			if(gradeEditionPostRequest.getTutorDni() != null && gradeEditionPostRequest.getTutorDni() != "") {
				gradeEdition.setTutorDni(gradeEditionPostRequest.getTutorDni());
			}
			gradeEditionRepository.save(gradeEdition);
			
			GradeEditionServiceModel response = new GradeEditionServiceModel(
					gradeEdition.getGradeEdId(),
					gradeEdition.getGradeId(),
					gradeEdition.getTutorDni(),
					gradeEdition.getFecha()
					);
			
			return new ResponseEntity<GradeEditionServiceModel>(response, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/gradeEditions/{id}")
	public ResponseEntity<Integer> deleteGradeEditionById(@PathVariable("id") Integer id){
		try {
			gradeEditionRepository.deleteById(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Grado no encontrado");
		}
				
	}
}
