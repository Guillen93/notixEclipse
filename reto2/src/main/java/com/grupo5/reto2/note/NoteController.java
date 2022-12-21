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
	private NoteRepository noteRepository;

	@GetMapping("/notes")
	public ResponseEntity<Iterable<Note>> getNote() {

		return new ResponseEntity<Iterable<Note>>(noteRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/notes")
	public ResponseEntity<Note> createNote(
			@RequestBody NotePostRequest notePostRequest) {

		Note note = new Note(
				notePostRequest.getStudent(),
				notePostRequest.getStudentDni(),
				notePostRequest.getSubject(),
				notePostRequest.getSubjectId(),
				notePostRequest.getEva1(),
				notePostRequest.getEva2(),
				notePostRequest.getEva3(),
				notePostRequest.getFinal1(),
				notePostRequest.getFinal2());
				
		
		Note response = noteRepository.save(note);

		return new ResponseEntity<Note>(response, HttpStatus.OK);
	}
	
	
	@PutMapping("/notes/{studentDNI}/{subjetId}")
	public void updateNoteByDoubleId(@PathVariable String studentDNI , @PathVariable Integer subjetId, @RequestBody NotePostRequest notePostRequest  ){

		noteRepository.updateBystudentDniAndSubjectId(studentDNI, subjetId,notePostRequest);
		
		
//		return new ResponseEntity<Integer>(noteRepository.updateByStudentDniAndSubjectId(studentDNI, subjetId),HttpStatus.OK);
	}
	
	@DeleteMapping("/notes/{studentDNI}/{subjetId}")
	public ResponseEntity<Integer> deleteNoteByDoubleId(@PathVariable String studentDNI , @PathVariable Integer subjetId ){

		//noteRepository.deleteByStudentDniAndSubjectId(studentDNI, subjetId);
		
		return new ResponseEntity<Integer>(noteRepository.deleteByStudentDniAndSubjectId(studentDNI, subjetId),HttpStatus.OK);
	}


	
	
}
