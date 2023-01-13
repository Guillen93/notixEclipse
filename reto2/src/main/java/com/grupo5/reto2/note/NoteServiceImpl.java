	package com.grupo5.reto2.note;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.student.Student;
import com.grupo5.reto2.student.StudentRepository;
import com.grupo5.reto2.subject.Subject;
import com.grupo5.reto2.subject.SubjectRepository;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteRepository noteRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Iterable<NoteServiceModel> getAllNotes() throws NotContentException {
		Iterable<Note> notes = noteRepository.findAll();

		List<NoteServiceModel> response = new ArrayList<NoteServiceModel>();
		
		if (notes == null) {
			throw new NotContentException("No hay ediciones de ese grado");
		}
		
		for (Note note : notes) {
			response.add(new NoteServiceModel(
					note.getId(),
					note.getStudentDni(),
					note.getSubjectId(),
					note.getEva1(),
					note.getEva2(),
					note.getEva3(),
					note.getFinal1(),
					note.getFinal2()
	
					));
		}
		return response;
	}

	@Override
	public NoteServiceModel getAllNoteById(String studentDNI, Integer subjetId) throws NotContentException {
		Note note = noteRepository.findByStudentDniAndSubjectId(studentDNI,subjetId);
		
		if (note == null) {
			throw new NotContentException("No existe el estudiante");
		}	

		NoteServiceModel response = new NoteServiceModel(
				note.getId(),
				note.getStudentDni(),
				note.getSubjectId(),
				note.getEva1(),
				note.getEva2(),
				note.getEva3(),
				note.getFinal1(),
				note.getFinal2()
				);

		return response;
	}
	
	@Override
	public Iterable<NoteServiceModel> getAllNotesByStudentDni(String studentDNI) throws NotContentException {
		
		Iterable<Note> notes = noteRepository.findByStudentDni(studentDNI);
		
		List<NoteServiceModel> response = new ArrayList<NoteServiceModel>();
		   
		if (notes == null) {
			throw new NotContentException("No existe el estudiante");
		}
		
	    for (Note  note : notes) {
            response.add(
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
		    return response;
	}

	@Override
	public NoteServiceModel createNotes(NotePostRequest notePostRequest) throws ConflictException, NotContentException {
		

		Student student =  studentRepository.findByStudentDni(notePostRequest.getStudentDni());
		Subject subject = subjectRepository.findBySubjectId(notePostRequest.getSubjectId());
		
		if(student == null && subject == null) {
			
			throw new NotContentException("El estudiante no se encuentra en el sistema por lo que no se puede crear una nota para el mismo");
			
		}else {
			Note note = noteRepository.findByStudentDniAndSubjectId(notePostRequest.getStudentDni(),notePostRequest.getSubjectId());
			if (note != null) {

				throw new ConflictException("El estudiante ya esta registrado");

			} else {

				note = new Note(
						student,
						notePostRequest.getStudentDni(),
						subject,
						notePostRequest.getSubjectId(),
						notePostRequest.getEva1(),
						notePostRequest.getEva2(),
						notePostRequest.getEva3(),
						notePostRequest.getFinal1(),
						notePostRequest.getFinal2()
						);

				note = noteRepository.save(note);
				
				NoteServiceModel response = new NoteServiceModel(
						note.getStudentDni(),
						note.getSubjectId(),
						note.getEva1(),
						note.getEva2(),
						note.getEva3(),
						note.getFinal1(),
						note.getFinal2()
				);
				return response;
			}
		}
		
	}

	@Override
	public NoteServiceModel updateNotes(String studentDNI, Integer subjetId, NotePostRequest notePostRequest) throws NotContentException {
		
	
		Note note = noteRepository.findByStudentDniAndSubjectId(studentDNI,subjetId);

		if (note == null) {

			throw new NotContentException("El estudiante ya esta registrado");

		} else {
			
			if(notePostRequest.getEva1()!=null) {
				note.setEva1(notePostRequest.getEva1());
			}
			if(notePostRequest.getEva2()!=null) {
				note.setEva2(notePostRequest.getEva2());
			}
			if(notePostRequest.getEva3()!=null) {
				note.setEva3(notePostRequest.getEva3());
			}
			if(notePostRequest.getFinal1()!=null) {
				note.setFinal1(notePostRequest.getFinal1());		
			}
			if(notePostRequest.getFinal2()!=null) {
				note.setFinal2(notePostRequest.getFinal2());
			}
			

			note = noteRepository.save(note);
			
			NoteServiceModel response = new NoteServiceModel(
					note.getStudentDni(),
					note.getSubjectId(),
					note.getEva1(),
					note.getEva2(),
					note.getEva3(),
					note.getFinal1(),
					note.getFinal2()
			);
			return response;
		}

	}

	@Override
	public Integer deleteNotesById(String studentDNI, Integer subjetId) {
		 Integer response = noteRepository.deleteByStudentDniAndSubjectId(studentDNI, subjetId);
		return response;
	}

	

}