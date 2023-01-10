package com.grupo5.reto2.grade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GradeServiceImpl implements GradeService{

	@Autowired
	GradeRepository gradeRepository;
	
	@Override
	public List<GradeServiceModel> findAllGrades() {
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
		return response;
	}

	@Override
	public ResponseEntity<GradeServiceModel> findByGradeId(Integer gradeId) {
		
		Grade grade = gradeRepository.findById(gradeId)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grado no encontrado"));
		
		GradeServiceModel response = new GradeServiceModel(
				grade.getGradeId(),
				grade.getName(),
				grade.getLanguage()
				);
		
		return new ResponseEntity<GradeServiceModel>(response,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Integer> createGrade(GradePostRequest gradePostRequest) {
		
		Grade response = new Grade(
				gradePostRequest.getGradeId(),
				gradePostRequest.getName(),
				gradePostRequest.getLanguage()
				);
		gradeRepository.save(response);
		
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> updateGrade(Integer gradeId, GradePostRequest gradePostRequest) {

		Boolean gradeAlreadyExists = gradeRepository.existsById(gradeId);
		
		
		if(!gradeAlreadyExists) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		} else {
			Grade response = gradeRepository.findById(gradeId).get();
			if(gradePostRequest.getName() != null && gradePostRequest.getName() != "") {
				response.setName(gradePostRequest.getName());
			}
			if(gradePostRequest.getLanguage() != null && gradePostRequest.getLanguage() != "") {
				response.setLanguage(gradePostRequest.getLanguage());
			}
			
			
			gradeRepository.save(response);
			
		}
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> deleteByGradeId(Integer gradeId) {
		
		return new ResponseEntity<Integer>(gradeRepository.deleteByGradeId(gradeId),HttpStatus.OK);
	
	}

}
