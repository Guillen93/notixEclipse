package com.grupo5.reto2.subject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.gradeEdition.GradeEdition;
import com.grupo5.reto2.gradeEdition.GradeEditionRepository;
import com.grupo5.reto2.professor.Professor;
import com.grupo5.reto2.professor.ProfessorRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	GradeEditionRepository gradeEditionRepository;

	@Override
	public Iterable<SubjectServiceModel> findAllSubject() throws NotContentException {
		Iterable<Subject> subjects = subjectRepository.findAll();

		List<SubjectServiceModel> response = new ArrayList<SubjectServiceModel>();

		if (subjects == null) {
			throw new NotContentException("No hay asignatura ");
		}

		for (Subject subject : subjects) {
			Professor professorbd = professorRepository.findByProfessorDni(subject.getProfessorDni());
			
			Professor professor = new Professor(
					professorbd.getProfessorDni(),
					professorbd.getName(),
					professorbd.getSurname(),
					professorbd.getNationality(),
					professorbd.getEmail(),
					professorbd.getAddres(),
					professorbd.getPhoto()
					);

			response.add(new SubjectServiceModel(
					subject.getSubjectId(),
					subject.getGradeId(),
					professor,
					subject.getProfessorDni(),
					subject.getName(),
					subject.getDuration()));
		}
		return response;

	}

	@Override
	public SubjectServiceModel findSubjectById(Integer subjetId) throws NotContentException {
		Subject subject = subjectRepository.findBySubjectId(subjetId);
		if (subject == null) {
			throw new NotContentException("No existe el estudiante");
		}
		
		Professor professorbd = professorRepository.findByProfessorDni(subject.getProfessorDni());
		
		Professor professor = new Professor(
				professorbd.getProfessorDni(),
				professorbd.getName(),
				professorbd.getSurname(),
				professorbd.getNationality(),
				professorbd.getEmail(),
				professorbd.getAddres(),
				professorbd.getPhoto()
		);
		
		SubjectServiceModel response = new SubjectServiceModel(
				subject.getSubjectId(),
				subject.getGradeId(),
				professor,
				subject.getProfessorDni(),
				subject.getName(),
				subject.getDuration()
		);

		return response;
	}

	@Override
	public SubjectServiceModel createSubject(SubjectPostRequest subjectPostRequest)
			throws ConflictException, NotContentException {
		

		Subject subject = subjectRepository.findBySubjectId(subjectPostRequest.getSubjectId());
		
		if (subject != null) {
			throw new ConflictException("La asignatura ya esta creada");
		}else {
			
			Professor professorbd = professorRepository.findByProfessorDni(subjectPostRequest.getProfessorDni());
			
			GradeEdition gradeEditionbd = gradeEditionRepository.findById(subjectPostRequest.getGradeId()).get();
			
			Professor professor = new Professor(
					professorbd.getProfessorDni(),
					professorbd.getName(),
					professorbd.getSurname(),
					professorbd.getNationality(),
					professorbd.getEmail(),
					professorbd.getAddres(),
					professorbd.getPhoto()
					);
			
			GradeEdition grade = new GradeEdition(
					gradeEditionbd.getGradeEdId(),
					gradeEditionbd.getGradeId(),
					gradeEditionbd.getTutorDni(),
					gradeEditionbd.getFecha()
					);
			
			
			subject = new Subject(
					grade,
					subjectPostRequest.getGradeId(),
					professor,
					subjectPostRequest.getProfessorDni(),
					subjectPostRequest.getName(),
					subjectPostRequest.getDuration()
					);
					
			subject = subjectRepository.save(subject);	
					
			SubjectServiceModel response = new SubjectServiceModel(
					subjectPostRequest.getGradeId(),
					professorRepository.findByProfessorDni(subject.getProfessorDni()),
					subjectPostRequest.getProfessorDni(),
					subjectPostRequest.getName(),
					subjectPostRequest.getDuration()
					);
			
			return response;
		}
	}

	@Override
	public SubjectServiceModel updateSubject(Integer subjectId, SubjectPostRequest subjectPostRequest)
			throws ConflictException, NotContentException {
		
		Subject subject = subjectRepository.findBySubjectId(subjectId);
		
		if (subject == null) {
			throw new NotContentException("No existe la asignatura");
		} else {

			if (subjectPostRequest.getGradeId() != null) {
				subject.setGradeId(subjectPostRequest.getGradeId());
			}
			if (subjectPostRequest.getProfessorDni() != null) {
				subject.setProfessorDni(subjectPostRequest.getProfessorDni());
			}
			if (subjectPostRequest.getName() != null) {
				subject.setName(subjectPostRequest.getName());
			}
			if (subjectPostRequest.getDuration() != null) {
				subject.setDuration(subjectPostRequest.getDuration());
			}

			subject = subjectRepository.save(subject);
			
			SubjectServiceModel response = new SubjectServiceModel(
					subjectId,
					subject.getGradeId(),
					subject.getProfessorDni(),
					subject.getName(),
					subject.getDuration()
			);	
			return response;
		}
	}

	@Override
	public Boolean deleteSubject(Integer subjectId) throws NotContentException {
		
		Boolean response = subjectRepository.existsById(subjectId);

		if (!response) {
			throw new NotContentException("No existe esa asignatura");
		}else {
			subjectRepository.deleteById(subjectId);
		}
			
		return response;
	}

}
