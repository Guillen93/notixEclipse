package com.grupo5.reto2.absence;

import java.sql.Date;

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

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

@RestController
@RequestMapping("api")
public class AbsenceController {

	@Autowired
	AbsenceService absenceService;

	@GetMapping("/absences")
	public ResponseEntity<Iterable<AbsenceServiceModel>> getAbsence() throws NotContentException {
		Iterable<AbsenceServiceModel> response = absenceService.getAllAbsences();
		return new ResponseEntity<Iterable<AbsenceServiceModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/absences/{studentDNI}")
	public ResponseEntity<Iterable<AbsenceServiceModel>> getAbsenceByStudentDni(@PathVariable String studentDNI)
			throws NotContentException {

		Iterable<AbsenceServiceModel> response = absenceService.getAllAbsencesByStudent(studentDNI);
		return new ResponseEntity<Iterable<AbsenceServiceModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/absences/{studentDNI}/{subjetId}")
	public ResponseEntity<AbsenceServiceModel> getNote(@PathVariable String studentDNI, @PathVariable Integer subjetId)
			throws NotContentException {

		AbsenceServiceModel response = absenceService.getAbsencesByStudentDniAndSubjectId(studentDNI, subjetId);
		return new ResponseEntity<AbsenceServiceModel>(response, HttpStatus.OK);

	}
	
	@PostMapping("/absences")
	public ResponseEntity<AbsenceServiceModel> createNote(@RequestBody AbsencePostRequest absencePostRequest) throws ConflictException, NotContentException {
		
		AbsenceServiceModel response = absenceService.createAbsence(absencePostRequest);
		return new ResponseEntity<AbsenceServiceModel>(response, HttpStatus.CREATED);
	}

	@PutMapping("/absences/{studentDNI}/{subjetId}/{dateString}")
	public ResponseEntity<AbsenceServiceModel> updateNoteByDoubleId(@PathVariable String studentDNI , @PathVariable Integer subjetId,@PathVariable String dateString, @RequestBody AbsencePostRequest absencePostRequest  ) throws NotContentException{

		
		AbsenceServiceModel response = absenceService.updateAbsence(studentDNI, subjetId,dateString ,absencePostRequest);

		return new ResponseEntity<AbsenceServiceModel>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/absences/{studentDNI}/{subjetId}/{dateString}")
	public ResponseEntity<Integer> deleteNoteByDoubleId(@PathVariable String studentDNI,
			@PathVariable Integer subjetId,@PathVariable String dateString) throws NotContentException {
		Date date=Date.valueOf(dateString);
		Integer response = absenceService.deleteAbsence(studentDNI,subjetId,date);

		if (response == 0) {
			throw new NotContentException("No existe nota con ID o Estudiante con ese DNI");
		} else {
			return new ResponseEntity<Integer>(HttpStatus.OK);
		}
	}
	

}
