package com.grupo5.reto2.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.subject.Subject;
import com.grupo5.reto2.subject.SubjectRepository;
import com.grupo5.reto2.user.User;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("api")
public class NoteController {

	@Autowired
	NoteService noteService;

	@Autowired
	SubjectRepository subjectRepository;

	@GetMapping("/notes")
	public ResponseEntity<Iterable<NoteServiceModel>> getNote() throws NotContentException {
		Iterable<NoteServiceModel> response = noteService.getAllNotes();
		return new ResponseEntity<Iterable<NoteServiceModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/notes/{studentDNI}/{subjetId}")
	public ResponseEntity<NoteServiceModel> getNote(@PathVariable String studentDNI, @PathVariable Integer subjetId)
			throws NotContentException {

		NoteServiceModel response = noteService.getAllNoteById(studentDNI, subjetId);
		return new ResponseEntity<NoteServiceModel>(response, HttpStatus.OK);

	}

	@GetMapping("/notes/student/{studentDNI}")
	public ResponseEntity<Iterable<NoteServiceModel>> getNote(@PathVariable String studentDNI)
			throws NotContentException {

		Iterable<NoteServiceModel> response = noteService.getAllNotesByStudentDni(studentDNI);
		return new ResponseEntity<Iterable<NoteServiceModel>>(response, HttpStatus.OK);

	}

	@GetMapping("/notes/professor/{professorDNI}")
	public ResponseEntity<Iterable<NoteServiceModel>> getNotesByProfessorDni(@PathVariable String professorDNI)
			throws NotContentException {

		Iterable<NoteServiceModel> response = noteService.getAllNotesByprofessorDni(professorDNI);
		return new ResponseEntity<Iterable<NoteServiceModel>>(response, HttpStatus.OK);

	}

	@PostMapping("/notesUpdate/create")
	public ResponseEntity<NoteServiceModel> createNote(@Valid @RequestBody NotePostRequest notePostRequest)
			throws ConflictException, NotContentException {

		NoteServiceModel response = noteService.createNotes(notePostRequest);
		return new ResponseEntity<NoteServiceModel>(response, HttpStatus.CREATED);
	}

	@PutMapping("/notesUpdate/{studentDNI}/{subjetId}")
	public ResponseEntity<NoteServiceModel> updateNoteByDoubleId(Authentication authentication,
			@PathVariable String studentDNI, @PathVariable Integer subjetId,
			@RequestBody NotePostRequest notePostRequest) throws NotContentException {
		
		User userDetails = (User) authentication.getPrincipal();
		
		Subject subject = subjectRepository.findBySubjectId(subjetId);

		
		if (subject.getProfessorDni().equals(userDetails.getDni())) {
			NoteServiceModel response = noteService.updateNotes(studentDNI, subjetId, notePostRequest);

			return new ResponseEntity<NoteServiceModel>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<NoteServiceModel>(HttpStatus.UNAUTHORIZED);
		}
	}

	@DeleteMapping("/notesUpdate/{studentDNI}/{subjetId}")
	public ResponseEntity<Integer> deleteNoteByDoubleId(Authentication authentication, @PathVariable String studentDNI,
			@PathVariable Integer subjetId) throws NotContentException {
		
		User userDetails = (User) authentication.getPrincipal();
		
		Subject subject = subjectRepository.findBySubjectId(subjetId);

		if (subject.getProfessorDni().equals(userDetails.getDni())) {

			Integer response = noteService.deleteNotesById(studentDNI, subjetId);

			if (response == 0) {
				throw new NotContentException("No existe nota con ID o Estudiante con ese DNI");
			} else {
				return new ResponseEntity<Integer>(HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

	}

}