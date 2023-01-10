package com.grupo5.reto2.subject;

import java.util.ArrayList;
import java.util.List;

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
public class SubjectController {

	@Autowired
	SubjectRepository subjectRepository;
	
	
	@GetMapping("/subjects")
	public ResponseEntity<Iterable<SubjectServiceModel>> getSubject() {
		
		
		
		Iterable<Subject> subjects = subjectRepository.findAll();
		
		   List<SubjectServiceModel> response = new ArrayList<SubjectServiceModel>();
		   
		    for (Subject  subject : subjects) {
	            response.add(
	                    new SubjectServiceModel(
	                    		subject.getSubjectId(),
	                    		subject.getGradeId(),
	                    		null,
	                            subject.getProfessorDni(),
	                            subject.getName(),
	                            subject.getDuration()
	                            )
	                     );
	        }
		    return new ResponseEntity <Iterable<SubjectServiceModel>> (response, HttpStatus.OK); 
	}
	
	@GetMapping("/subjects/{subjetId}")
	public ResponseEntity<SubjectServiceModel> getSubjectById(@PathVariable Integer subjetId ) {
		
		
		
		Subject subject = subjectRepository.findBySubjectId(subjetId);
		   
	           
		SubjectServiceModel response = new SubjectServiceModel(
	                    		subject.getSubjectId(),
	                    		subject.getGradeId(),
	                    		null,
	                            subject.getProfessorDni(),
	                            subject.getName(),
	                            subject.getDuration()
	                            );
	                    
	        
		    return new ResponseEntity <SubjectServiceModel> (response, HttpStatus.OK); 
	}
	
	
	@PostMapping("/subjects")
	public ResponseEntity<Subject> createSubject(@RequestBody SubjectPostRequest subjectPostRequest ) {
		
		Subject response = new Subject(
								subjectPostRequest.getSubjectId(),
								subjectPostRequest.getGradeId(),
	                    		subjectPostRequest.getProfessorDni(),
	                    		subjectPostRequest.getName(),
	                    		subjectPostRequest.getDuration()
	                            );
					subjectRepository.save(response);     
	        
		    return new ResponseEntity <Subject> (response, HttpStatus.OK); 
	}
	
	
	@PutMapping("/subjects/{subjectId}")
	public ResponseEntity<Subject> updateSubject(@PathVariable Integer subjectId ,@RequestBody SubjectPostRequest subjectPostRequest ) {
		
		Subject response = new Subject(
								subjectId,
								subjectPostRequest.getGradeId(),
	                    		subjectPostRequest.getProfessorDni(),
	                    		subjectPostRequest.getName(),
	                    		subjectPostRequest.getDuration()
	                            );
					subjectRepository.save(response);     
	        
		    return new ResponseEntity <Subject> (response, HttpStatus.OK); 
	}
	
	@DeleteMapping("/subjects/{subjectId}")
	public ResponseEntity<Integer> deleteSubject(@PathVariable Integer subjectId ) {
		
	
					subjectRepository.deleteById(subjectId);     
	        
		    return new ResponseEntity <Integer> ( HttpStatus.OK); 
	}
	
	
}
