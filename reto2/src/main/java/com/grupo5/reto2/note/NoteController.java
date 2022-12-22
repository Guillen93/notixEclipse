package com.grupo5.reto2.note;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Iterable<NoteServiceModel>> getNote() {

		Iterable<Note> notes = noteRepository.findAll();
		
		   List<NoteServiceModel> response = new ArrayList<NoteServiceModel>();
		   
		    for (Note  note : notes) {
	            response.add(
	                    new NoteServiceModel(
	                    		null,
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
		    return new ResponseEntity <Iterable<NoteServiceModel>> (response, HttpStatus.OK);    
	
		    
	}
	
	@GetMapping("/notes/{studentDNI}/{subjetId}")
	public ResponseEntity<NoteServiceModel> getNote(@PathVariable String studentDNI , @PathVariable Integer subjetId ) {

		Note note = noteRepository.findByStudentDniAndSubjectId(studentDNI,subjetId);
		
		   NoteServiceModel response = new NoteServiceModel(
	                    		null,
	                            note.getStudentDni(),
	                            note.getSubjectId(),
	                            note.getEva1(),
	                            note.getEva2(),
	                            note.getEva3(),
	                            note.getFinal1(),
	                            note.getFinal2()
	                            );
	                     
	        
		    return new ResponseEntity<NoteServiceModel> (response, HttpStatus.OK);    
	
		    
	}
	
	
	@PostMapping("/notes")
	public ResponseEntity<Note> createNote(
						@RequestBody NotePostRequest notePostRequest) {

		Note note = new Note(
				null,
				notePostRequest.getStudentDni(),
				null,
				notePostRequest.getSubjectId(),
				notePostRequest.getEva1(),
				notePostRequest.getEva2(),
				notePostRequest.getEva3(),
				notePostRequest.getFinal1(),
				notePostRequest.getFinal2());
				
		
		Note response = noteRepository.save(note);

		return new ResponseEntity<Note>(response, HttpStatus.OK);
	}
	
//	@PutMapping("/notes/{studentDNI}/{subjetId}")
//	public void updateNoteByDoubleId(@PathVariable String studentDNI , @PathVariable Integer subjetId, @RequestBody NotePostRequest notePostRequest  ){
//
//		
//		
//		noteRepository.updateBystudentDniAndSubjectId(studentDNI, subjetId,notePostRequest);
//		
//		
//	//	return new ResponseEntity<Integer>(noteRepository.updateBystudentDniAndSubjectId(studentDNI, subjetId),HttpStatus.OK);
//	}
	
	

	
	
//	@PutMapping("/notes/{studentDNI}/{subjetId}")
//	public void updateNoteByDoubleId(@PathVariable String studentDNI , @PathVariable Integer subjetId, @RequestBody NotePostRequest notePostRequest  ){
//
//		noteRepository.updateBystudentDniAndSubjectId(studentDNI, subjetId,notePostRequest);
//		
//		
////		return new ResponseEntity<Integer>(noteRepository.updateByStudentDniAndSubjectId(studentDNI, subjetId),HttpStatus.OK);
//	}
	
//	@DeleteMapping("/notes/{studentDNI}/{subjetId}")
//	public ResponseEntity<Integer> deleteNoteByDoubleId(@PathVariable String studentDNI , @PathVariable Integer subjetId ){
//
//		//noteRepository.deleteByStudentDniAndSubjectId(studentDNI, subjetId);
//		
//		return new ResponseEntity<Integer>(noteRepository.deleteByStudentDniAndSubjectId(studentDNI, subjetId),HttpStatus.OK);
//	}


	
	
}
