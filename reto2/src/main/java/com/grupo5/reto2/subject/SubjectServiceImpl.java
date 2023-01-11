package com.grupo5.reto2.subject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.professor.Professor;
import com.grupo5.reto2.professor.ProfessorRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public Iterable<SubjectServiceModel> findAllSubject() throws NotContentException {
		Iterable<Subject> subjects = subjectRepository.findAll();

		List<SubjectServiceModel> response = new ArrayList<SubjectServiceModel>();

		if (subjects == null) {
			throw new NotContentException("No hay asignatura ");
		}

		for (Subject subject : subjects) {
			Professor professorbd = professorRepository.findByProfessorDni(subject.getProfessorDni());
			Professor professor = new Professor(professorbd.getProfessorDni(), professorbd.getName(),
					professorbd.getSurname(), professorbd.getNationality(), professorbd.getEmail(),
					professorbd.getAddres(), professorbd.getPhoto()

			);

			response.add(new SubjectServiceModel(subject.getSubjectId(), subject.getGradeId(), professor,
					subject.getProfessorDni(), subject.getName(), subject.getDuration()));
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
		
		if (subject == null) {
			throw new NotContentException("La asignatura ya esta creada");
		}
			
		subject = new Subject(
				subjectPostRequest.getGradeId(),
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

	@Override
	public SubjectServiceModel uupdateSubject(Integer subjectId, SubjectPostRequest subjectPostRequest)
			throws ConflictException, NotContentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteSubject(Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
