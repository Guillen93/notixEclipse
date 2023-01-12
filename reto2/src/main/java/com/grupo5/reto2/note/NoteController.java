package com.grupo5.reto2.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class NoteController {

	@Autowired
	NoteService noteService;

	@GetMapping("/notes")
	public ResponseEntity<Iterable<NoteServiceModel>> getNote() {
		Iterable<NoteServiceModel> response = noteService.getAllNotes();
		return new ResponseEntity<Iterable<NoteServiceModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/notes/{studentDNI}/{subjetId}")
	public ResponseEntity<NoteServiceModel> getNote(@PathVariable String studentDNI, @PathVariable Integer subjetId) {

		NoteServiceModel response = noteService.getAllNoteById(studentDNI, subjetId);
		return new ResponseEntity<NoteServiceModel>(response, HttpStatus.OK);

	}

	@GetMapping("/notes/{studentDNI}")
	public ResponseEntity<Iterable<NoteServiceModel>> getNote(@PathVariable String studentDNI ) {

		Iterable<NoteServiceModel> response = noteService.getAllNotesByStudentDni(studentDNI);
		return new ResponseEntity<Iterable<NoteServiceModel>>(response, HttpStatus.OK);
		    
	}

	@PostMapping("/notes")
	public ResponseEntity<NoteServiceModel> createNote(@RequestBody NotePostRequest notePostRequest) {
		
		NoteServiceModel response = noteService.createNotes(notePostRequest);
		return new ResponseEntity<NoteServiceModel>(response, HttpStatus.CREATED);
	}

	@PutMapping("/notes/{studentDNI}/{subjetId}")
	public ResponseEntity<NoteServiceModel> updateNoteByDoubleId(@PathVariable String studentDNI , @PathVariable Integer subjetId, @RequestBody NotePostRequest notePostRequest  ){

		NoteServiceModel response = noteService.updateNotes(studentDNI, subjetId,notePostRequest);

		return new ResponseEntity<NoteServiceModel>(response, HttpStatus.OK);
	}



	@DeleteMapping("/notes/{studentDNI}/{subjetId}")
	public ResponseEntity<Integer> deleteNoteByDoubleId(@PathVariable String studentDNI,
			@PathVariable Integer subjetId) {

		Integer response = noteService.deleteNotesById(studentDNI,subjetId);

		if (response == 0) {
			//throw new NotContentException("No existe nota con ID o Estudiante con ese DNI");
		} else {
			//return new ResponseEntity<Integer>(HttpStatus.OK);
		}
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

}
