package com.grupo5.reto2.note;


public interface NoteService {

	Iterable<NoteServiceModel> getAllNotes();
	NoteServiceModel getAllNoteById(String studentDNI , Integer subjetId);
	Iterable<NoteServiceModel> getAllNotesByStudentDni(String studentDNI );
	NoteServiceModel createNotes(NotePostRequest notePostRequest);
	NoteServiceModel updateNotes(String studentDNI ,Integer subjetId, NotePostRequest notePostRequest);
	Integer deleteNotesById(String studentDNI ,Integer subjetId);
	
	
}
