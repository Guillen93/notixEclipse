package com.grupo5.reto2.note;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public Iterable<NoteServiceModel> getAllNotes() {
		Iterable<Note> notes = noteRepository.findAll();

		List<NoteServiceModel> response = new ArrayList<NoteServiceModel>();
		
		if (notes == null) {
			//throw new NotContentException("No hay ediciones de ese grado");
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
	public NoteServiceModel getAllNoteById(String studentDNI, Integer subjetId) {
		Note note = noteRepository.findByStudentDniAndSubjectId(studentDNI,subjetId);
		
		if (note == null) {
			//throw new NotContentException("No existe el estudiante");
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
	public Iterable<NoteServiceModel> getAllNotesByStudentDni(String studentDNI) {
		
	Iterable<Note> notes = noteRepository.findByStudentDni(studentDNI);
		
		List<NoteServiceModel> response = new ArrayList<NoteServiceModel>();
		   
		if (notes == null) {
			//throw new NotContentException("No existe el estudiante");
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
	public NoteServiceModel createNotes(NotePostRequest notePostRequest) {
//		Iterable<Note> notes = noteRepository.findByStudentDni(notePostRequest.getStudentDni());
//
//		if (notes != null) {
//
//			//throw new ConflictException("El estudiante ya esta registrado");
//
//		} else {

			Note note = new Note(
					null,
					notePostRequest.getStudentDni(),
					null,
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
//		}
//		return null;
	}

	@Override
	public NoteServiceModel updateNotes(String studentDNI, Integer subjetId, NotePostRequest notePostRequest) {
		
	
		Note note = noteRepository.findByStudentDniAndSubjectId(studentDNI,subjetId);

		if (note == null) {

			//throw new NoContentException("El estudiante ya esta registrado");

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
		return null;
	}

	@Override
	public Integer deleteNotesById(String studentDNI, Integer subjetId) {
		 Integer response = noteRepository.deleteByStudentDniAndSubjectId(studentDNI, subjetId);
		return response;
	}

	

}
