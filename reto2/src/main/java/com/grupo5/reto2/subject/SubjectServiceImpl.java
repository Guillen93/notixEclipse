package com.grupo5.reto2.subject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.grade.GradeRepository;
import com.grupo5.reto2.gradeEdition.GradeEdition;
import com.grupo5.reto2.gradeEdition.GradeEditionRepository;
import com.grupo5.reto2.note.Note;
import com.grupo5.reto2.note.NoteRepository;
import com.grupo5.reto2.note.NoteServiceModel;
import com.grupo5.reto2.professor.Professor;
import com.grupo5.reto2.professor.ProfessorRepository;
import com.grupo5.reto2.student.StudentRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	GradeEditionRepository gradeEditionRepository;
	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	NoteRepository noteRepository;
	@Autowired
	StudentRepository studentRepository;

	
	@Override
	public Iterable<SubjectServiceModel> findAllSubject() throws NotContentException {
		Iterable<Subject> subjects = subjectRepository.findAll();

		List<SubjectServiceModel> response = new ArrayList<SubjectServiceModel>();

		if (subjects == null || subjects.iterator().hasNext()==false) {
			throw new NotContentException("No hay asignatura ");
		}

		for (Subject subject : subjects) {
			
			response.add(new SubjectServiceModel(
					subject.getSubjectId(),
					subject.getGradeEdId(),
					subject.getProfessorDni(),
					subject.getName(),
					subject.getDuration()
					));
		}
		return response;

	}

	@Override
	public SubjectServiceModel findSubjectById(Integer subjetId) throws NotContentException {
		Subject subject = subjectRepository.findBySubjectId(subjetId);
		if (subject == null) {
			throw new NotContentException("No existe el estudiante");
		}
		
		SubjectServiceModel response = new SubjectServiceModel(
				subject.getSubjectId(),
				subject.getGradeEdId(),
				subject.getProfessorDni(),
				subject.getName(),
				subject.getDuration()
		);

		return response;
	}

	@Override
	public Iterable<SubjectServiceModel> findSubjectsByStudentDni(String dni) throws NotContentException {
		
		Boolean studentExists = studentRepository.existsByStudentDni(dni);
		
		if(!studentExists) {
			throw new NotContentException("No existe el estudiante");
		}else {
			Iterable<Note> notesBD = noteRepository.findByStudentDni(dni);

			
			List<NoteServiceModel> notes = new ArrayList<NoteServiceModel>();
			   
			if (notesBD == null || notesBD.iterator().hasNext()==false) {
				throw new NotContentException("No existe el estudiante");
			}
			
		    for (Note  note : notesBD) {
		    	notes.add(
	                    new NoteServiceModel(
	                    		note.getId(),
	                            note.getStudentDni(),
	                            note.getSubjectId(),
	                            note.getEva1(),
	                            note.getEva2(),
	                            note.getEva3(),
	                            note.getFinal1(),
	                            note.getFinal2()
	                            )
	                     );
	        }
		    
		    ArrayList<Subject> ListsubjectsById = new ArrayList<Subject>();
			
		    for(int i = 0;i<notes.size();i++) {
		    	
		    	Subject subjectToBd = subjectRepository.findById(notes.get(i).getSubjectId()).get();
		    	
		    	
		    	ListsubjectsById.add(subjectToBd);
		    	
		    	
		    }
			
		    List<SubjectServiceModel> response = new ArrayList<SubjectServiceModel>();

			for (Subject subject : ListsubjectsById) {
				
				response.add(new SubjectServiceModel(
						subject.getSubjectId(),
						subject.getGradeEdId(),
						subject.getProfessorDni(),
						subject.getName(),
						subject.getDuration()
						));
			}
			return response;
		}
		
		
	}
	
	@Override
	public Iterable<SubjectServiceModel> findSubjectsByProfessorDni(String dni) throws NotContentException {
		
		
		Iterable<Subject> subjects = subjectRepository.findByProfessorDni(dni);

		List<SubjectServiceModel> response = new ArrayList<SubjectServiceModel>();

		if (subjects == null || subjects.iterator().hasNext()==false) {
			throw new NotContentException("No hay asignatura ");
		}

		for (Subject subject : subjects) {
			
			response.add(new SubjectServiceModel(
					subject.getSubjectId(),
					subject.getGradeEdId(),
					subject.getProfessorDni(),
					subject.getName(),
					subject.getDuration()
					));
		}
		return response;
	}
	
	@Override
	public SubjectServiceModel createSubject(SubjectPostRequest subjectPostRequest)
			throws ConflictException, NotContentException {
		
		Subject subject = subjectRepository.findByName(subjectPostRequest.getName());
		
		if (subject != null) {
			throw new ConflictException("La asignatura ya esta creada");
		}else {
			
			
			Professor professorbd = professorRepository.findByProfessorDni(subjectPostRequest.getProfessorDni());
			
			GradeEdition gradeEditionbd = gradeEditionRepository.findById(subjectPostRequest.getGradeEditionId()).get();
			
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
					subjectPostRequest.getGradeEditionId(),
					professor,
					subjectPostRequest.getProfessorDni(),
					subjectPostRequest.getName(),
					subjectPostRequest.getDuration()
					);
					
			subject = subjectRepository.save(subject);	
					
			SubjectServiceModel response = new SubjectServiceModel(
					subject.getSubjectId(),
					subject.getGradeEdId(),
					subject.getProfessorDni(),
					subject.getName(),
					subject.getDuration()
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

			if (subjectPostRequest.getGradeEditionId() != null) {
				subject.setGradeEdId(subjectPostRequest.getGradeEditionId());
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
					subject.getGradeEdId(),
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
