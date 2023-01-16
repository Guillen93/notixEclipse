package com.grupo5.reto2.note;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface NoteService {

	Iterable<NoteServiceModel> getAllNotes() throws NotContentException;
	NoteServiceModel getAllNoteById(String studentDNI , Integer subjetId) throws NotContentException;
	Iterable<NoteServiceModel> getAllNotesByStudentDni(String studentDNI ) throws NotContentException;
	Iterable<NoteServiceModel> getAllNotesByprofessorDni(String professorDNI ) throws NotContentException;
	NoteServiceModel createNotes(NotePostRequest notePostRequest) throws ConflictException, NotContentException;
	NoteServiceModel updateNotes(String studentDNI ,Integer subjetId, NotePostRequest notePostRequest) throws NotContentException;
	Integer deleteNotesById(String studentDNI ,Integer subjetId);
	
	
}