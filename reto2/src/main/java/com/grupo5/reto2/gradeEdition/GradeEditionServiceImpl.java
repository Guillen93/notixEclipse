package com.grupo5.reto2.gradeEdition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GradeEditionServiceImpl implements GradeEditionService {

	@Autowired
	GradeEditionRepository gradeEditionRepository;

	@Override
	public List<GradeEditionServiceModel> findAllGradeEditions() {

		Iterable<GradeEdition> gradeEditions = gradeEditionRepository.findAll();

		List<GradeEditionServiceModel> response = new ArrayList<GradeEditionServiceModel>();

		for (GradeEdition gradeEdition : gradeEditions) {
			response.add(new GradeEditionServiceModel(gradeEdition.getGradeEdId(), gradeEdition.getGradeId(),
					gradeEdition.getTutorDni(), gradeEdition.getFecha()));
		}
		return response;
	}

	@Override
	public GradeEditionServiceModel findByGradeEditionId(Integer gradeEditionId) {

		GradeEdition gradeEdition = gradeEditionRepository.findById(gradeEditionId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Edicion de grado no encontrado"));

		GradeEditionServiceModel response = new GradeEditionServiceModel(gradeEdition.getGradeEdId(),
				gradeEdition.getGradeId(), gradeEdition.getTutorDni(), gradeEdition.getFecha());

		return response;
	}

	@Override
	public GradeEdition createGradeEdition(GradeEditionPostRequest gradeEditionPostRequest) {

		GradeEdition response = new GradeEdition();
		
		GradeEdition gradeEdition = new GradeEdition(gradeEditionPostRequest.getGradeEdId(),
				gradeEditionPostRequest.getGradeId(), gradeEditionPostRequest.getTutorDni(),
				gradeEditionPostRequest.getFecha());
		response = gradeEditionRepository.save(gradeEdition);
		

		return response;
	}

	@Override
	public Boolean updateGradeEdition(Integer gradeEditionId,
			GradeEditionPostRequest gradeEditionPostRequest) {

		Boolean gradeEditionAlreadyExists = gradeEditionRepository.existsById(gradeEditionId);

		GradeEdition gradeEdition = new GradeEdition(gradeEditionId, gradeEditionPostRequest.getGradeId(),
				gradeEditionPostRequest.getTutorDni(), gradeEditionPostRequest.getFecha());

		if (!gradeEditionAlreadyExists) {
			return !gradeEditionAlreadyExists;
			
		} else {
			if (gradeEditionPostRequest.getGradeId() != null) {
				gradeEdition.setGradeId(gradeEditionPostRequest.getGradeId());
			}
			if (gradeEditionPostRequest.getTutorDni() != null && gradeEditionPostRequest.getTutorDni() != "") {
				gradeEdition.setTutorDni(gradeEditionPostRequest.getTutorDni());
			}
			gradeEditionRepository.save(gradeEdition);
			gradeEditionAlreadyExists =true;
		}
		Boolean response = gradeEditionAlreadyExists;
		
		return response;
	}

	@Override
	public Boolean deleteByGradeEditionId(Integer gradeEditionId) {
		
		Boolean response = false;
		try {
			gradeEditionRepository.deleteById(gradeEditionId);
			response = true;;
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Grado no encontrado");
		}
		return response;
	}

}
