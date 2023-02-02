package com.grupo5.reto2.grade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	GradeRepository gradeRepository;

	@Override
	public List<GradeServiceModel> findAllGrades() throws NotContentException {
		Iterable<Grade> grades = gradeRepository.findAll();

		List<GradeServiceModel> response = new ArrayList<GradeServiceModel>();

		if (grades == null || grades.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Grade grade : grades) {
			response.add(new GradeServiceModel(grade.getGradeId(), grade.getName(), grade.getLanguage()));
		}
		return response;
	}

	@Override
	public GradeServiceModel findByGradeId(Integer gradeId) throws NotContentException {

		Grade grade = gradeRepository.findById(gradeId)
				.orElseThrow(() -> new NotContentException("No existe el estudiante"));

		GradeServiceModel response = new GradeServiceModel(grade.getGradeId(), grade.getName(), grade.getLanguage());

		return response;
	}

	@Override
	public GradeServiceModel createGrade(GradePostRequest gradePostRequest) throws ConflictException {

		Grade gradeBd = gradeRepository.findByNameAndLanguage(gradePostRequest.getName(),
				gradePostRequest.getLanguage());

		if (gradeBd != null) {
			throw new ConflictException("El estudiante ya esta registrado");
		} else {
			Grade grade = new Grade(gradePostRequest.getGradeId(), gradePostRequest.getName(),
					gradePostRequest.getLanguage());

			grade = gradeRepository.save(grade);

			GradeServiceModel response = new GradeServiceModel(grade.getGradeId(), grade.getName(),
					grade.getLanguage());

			return response;
		}
	}

	@Override
	public GradeServiceModel updateGrade(Integer gradeId, GradePostRequest gradePostRequest)
			throws NotContentException {

		Boolean existe = gradeRepository.existsById(gradeId);

		if (!existe) {
			throw new NotContentException("No existe el estudiante");
		} else {
			Grade grade = gradeRepository.findById(gradeId).get();
			if (gradePostRequest.getName() != null && gradePostRequest.getName() != "") {
				grade.setName(gradePostRequest.getName());
			}
			if (gradePostRequest.getLanguage() != null && gradePostRequest.getLanguage() != "") {
				grade.setLanguage(gradePostRequest.getLanguage());
			}

			grade = gradeRepository.save(grade);

			GradeServiceModel response = new GradeServiceModel(gradeId, grade.getName(), grade.getLanguage());
			return response;
		}

	}

	@Override
	public Integer deleteByGradeId(Integer gradeId) {

		return gradeRepository.deleteByGradeId(gradeId);
	}

}
