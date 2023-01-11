package com.grupo5.reto2.grade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	public GradeServiceModel findByGradeId(Integer gradeId) {
		
		Grade grade = gradeRepository.findById(gradeId)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grado no encontrado"));
		
		GradeServiceModel response = new GradeServiceModel(
				grade.getGradeId(),
				grade.getName(),
				grade.getLanguage()
				);
		
		return response;

	}

	@Override
	public Boolean createGrade(GradePostRequest gradePostRequest) {
		
		Grade gradeBd = gradeRepository.findByName(gradePostRequest.getName());
		Boolean response = false;
		if(gradeBd == null) {
		Grade grade = new Grade(
				gradePostRequest.getGradeId(),
				gradePostRequest.getName(),
				gradePostRequest.getLanguage()
				);
		gradeRepository.save(grade);
		response = true;
		}
		
		return response;
	}

	@Override
	public Boolean updateGrade(Integer gradeId, GradePostRequest gradePostRequest) {

		Boolean gradeAlreadyExists = gradeRepository.existsById(gradeId);
		
		
		if(!gradeAlreadyExists) {
			return !gradeAlreadyExists;
		} else {
			Grade grade = gradeRepository.findById(gradeId).get();
			if(gradePostRequest.getName() != null && gradePostRequest.getName() != "") {
				grade.setName(gradePostRequest.getName());
			}
			if(gradePostRequest.getLanguage() != null && gradePostRequest.getLanguage() != "") {
				grade.setLanguage(gradePostRequest.getLanguage());
			}
			
			gradeRepository.save(grade);
			gradeAlreadyExists = true;
			
		}
		Boolean response = gradeAlreadyExists;
		
		return response;
	}

	@Override
	public Boolean deleteByGradeId(Integer gradeId) {
		
		Boolean response = false;
		try {
			gradeRepository.deleteByGradeId(gradeId);
			response = true;;
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Grado no encontrado");
		}
		return response;
		
	
	}



}
