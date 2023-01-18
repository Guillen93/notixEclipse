package com.grupo5.reto2.gradeEdition;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.grade.Grade;
import com.grupo5.reto2.grade.GradeRepository;
import com.grupo5.reto2.professor.Professor;
import com.grupo5.reto2.professor.ProfessorRepository;
import com.grupo5.reto2.student.StudentRepository;
import com.grupo5.reto2.user.UserRepository;

@Service
public class GradeEditionServiceImpl implements GradeEditionService {

	@Autowired
	GradeEditionRepository gradeEditionRepository;

	@Autowired
	GradeRepository gradeRepository;

	@Autowired
	ProfessorRepository professorRepository;

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Iterable<GradeEditionServiceModel> findAllGradeEditions() throws NotContentException {

		Iterable<GradeEdition> gradeEditions = gradeEditionRepository.findAll();

		List<GradeEditionServiceModel> response = new ArrayList<GradeEditionServiceModel>();

		if (gradeEditions == null || gradeEditions.iterator().hasNext() == false) {
			throw new NotContentException("No hay ediciones de ese grado");
		}

		for (GradeEdition gradeEdition : gradeEditions) {
			response.add(new GradeEditionServiceModel(gradeEdition.getGradeEdId(), gradeEdition.getGradeId(),
					gradeEdition.getTutorDni(), gradeEdition.getFecha().toString()));
		}
		return response;
	}

	@Override
	public GradeEditionServiceModel findByGradeEditionId(Integer gradeEditionId) throws NotContentException {

		GradeEdition gradeEdition = gradeEditionRepository.findById(gradeEditionId)
				.orElseThrow(() -> new NotContentException("Edicion de grado no encontrado"));

		GradeEditionServiceModel response = new GradeEditionServiceModel(gradeEdition.getGradeEdId(),
				gradeEdition.getGradeId(), gradeEdition.getTutorDni(), gradeEdition.getFecha().toString());

		return response;
	}

	@Override
	public GradeEditionServiceModel createGradeEdition(GradeEditionPostRequest gradeEditionPostRequest)
			throws ConflictException {

		GradeEdition gradeEdition = gradeEditionRepository
				.findByGradeIdAndTutorDni(gradeEditionPostRequest.getGradeId(), gradeEditionPostRequest.getTutorDni());

		if (gradeEdition != null) {

			throw new ConflictException("Esa edicion de grado  ya esta registrado");

		} else {

			Grade grade = gradeRepository.findById(gradeEditionPostRequest.getGradeId()).get();
			Professor professor = professorRepository.findByProfessorDni(gradeEditionPostRequest.getTutorDni());

			gradeEdition = new GradeEdition(gradeEditionPostRequest.getGradeEdId(),
					grade,
					gradeEditionPostRequest.getGradeId(), 
					professor, 
					gradeEditionPostRequest.getTutorDni(),
					Date.valueOf(gradeEditionPostRequest.getFecha())

			);

			gradeEditionRepository.save(gradeEdition);

			GradeEditionServiceModel response = new GradeEditionServiceModel(gradeEdition.getGradeEdId(),
					gradeEdition.getGradeId(), gradeEdition.getTutorDni(), gradeEdition.getFecha().toString());

			return response;
		}
	}

	@Override
	public GradeEditionServiceModel updateGradeEdition(Integer gradeEditionId,
			GradeEditionPostRequest gradeEditionPostRequest) throws NotContentException {

		GradeEdition gradeEdition = gradeEditionRepository.findByGradeEditionId(gradeEditionId);

		if (gradeEdition == null) {
			throw new NotContentException("No existe esa edicion de grado");

		} else {
			if (gradeEditionPostRequest.getGradeId() != null) {
				gradeEdition.setGradeId(gradeEditionPostRequest.getGradeId());
			}
			if (gradeEditionPostRequest.getTutorDni() != null && gradeEditionPostRequest.getTutorDni() != "") {
				gradeEdition.setTutorDni(gradeEditionPostRequest.getTutorDni());
			}
			if (gradeEditionPostRequest.getFecha() != null) {
				gradeEdition.setFecha(Date.valueOf(gradeEditionPostRequest.getFecha()));
			}

			gradeEdition = gradeEditionRepository.save(gradeEdition);

			GradeEditionServiceModel response = new GradeEditionServiceModel(gradeEditionId, gradeEdition.getGradeId(),
					gradeEdition.getTutorDni(), gradeEdition.getFecha().toString());

			return response;
		}

	}

	@Override
	public Boolean deleteById(Integer gradeEditionId) throws NotContentException {

		Boolean response = gradeEditionRepository.existsById(gradeEditionId);

		if (!response) {
			throw new NotContentException("No existe esa edicion de grado");
		} else {
			gradeEditionRepository.deleteById(gradeEditionId);
		}

		return response;
	}

	@Override
	public Iterable<GradeEditionServiceModel> getGradeEditionByDni(String studentDNI) throws NotContentException {

		Boolean studentExists = studentRepository.existsByStudentDni(studentDNI);

		if (!studentExists) {

			throw new NotContentException("Alumno no encontrado en el sistema");

		} else {

			Iterable<GradeEdition> gradeEditions = gradeEditionRepository.findGradeEditionByPromotionsStudentDni(studentDNI);

			List<GradeEditionServiceModel> response = new ArrayList<GradeEditionServiceModel>();
			
			for (GradeEdition gradeEdition : gradeEditions) {
				response.add(new GradeEditionServiceModel(gradeEdition.getGradeEdId(), gradeEdition.getGradeId(),
						gradeEdition.getTutorDni(), gradeEdition.getFecha().toString()));
			}
			return response;

		}

	}

}
