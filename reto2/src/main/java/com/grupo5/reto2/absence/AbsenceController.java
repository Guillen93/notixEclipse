package com.grupo5.reto2.absence;

import java.sql.Date;

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
public class AbsenceController {

	@Autowired
	AbsenceService absenceService;
	@Autowired
	SubjectRepository subjectRepository;

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
	public ResponseEntity<Iterable<AbsenceServiceModel>> getNote(@PathVariable String studentDNI,
			@PathVariable Integer subjetId) throws NotContentException {

		return new ResponseEntity<Iterable<AbsenceServiceModel>>(
				absenceService.getAbsencesByStudentDniAndSubjectId(studentDNI, subjetId), HttpStatus.OK);

	}

	@GetMapping("/absences/{studentDNI}/justified")
	public ResponseEntity<Iterable<AbsenceServiceModel>> getAbsenceByStudentDniWhileJustifiedTrue(
			@PathVariable String studentDNI) throws NotContentException {

		Iterable<AbsenceServiceModel> response = absenceService.getAbsencesByStudentDniAndJustified(studentDNI);
		return new ResponseEntity<Iterable<AbsenceServiceModel>>(response, HttpStatus.OK);

	}

	@PostMapping("/absences")
	public ResponseEntity<AbsenceServiceModel> createNote(@Valid @RequestBody AbsencePostRequest absencePostRequest)
			throws ConflictException, NotContentException {

		AbsenceServiceModel response = absenceService.createAbsence(absencePostRequest);
		return new ResponseEntity<AbsenceServiceModel>(response, HttpStatus.CREATED);
	}

	@PutMapping("/absencesUpdate/{studentDNI}/{subjetId}/{dateString}")
	public ResponseEntity<AbsenceServiceModel> updateNoteByDoubleId(Authentication authentication,
			@PathVariable String studentDNI, @PathVariable Integer subjetId, @PathVariable String dateString,
			@RequestBody AbsencePostRequest absencePostRequest) throws NotContentException {

		User userDetails = (User) authentication.getPrincipal();

		Subject subject = subjectRepository.findBySubjectId(subjetId);

		if (subject.getProfessorDni().equals(userDetails.getDni())) {

			return new ResponseEntity<AbsenceServiceModel>(
					absenceService.updateAbsence(studentDNI, subjetId, dateString, absencePostRequest), HttpStatus.OK);
		} else {
			return new ResponseEntity<AbsenceServiceModel>(HttpStatus.UNAUTHORIZED);
		}

	}

	@DeleteMapping("/absencesDelete/{studentDNI}/{subjetId}/{dateString}")
	public ResponseEntity<Integer> deleteNoteByDoubleId(Authentication authentication, @PathVariable String studentDNI,
			@PathVariable Integer subjetId, @PathVariable String dateString) throws NotContentException {

		User userDetails = (User) authentication.getPrincipal();

		Subject subject = subjectRepository.findBySubjectId(subjetId);

		if (subject.getProfessorDni().equals(userDetails.getDni())) {

			Date date = Date.valueOf(dateString);
			Integer response = absenceService.deleteAbsence(studentDNI, subjetId, date);

			if (response == 0) {
				throw new NotContentException("No existe nota con ID o Estudiante con ese DNI");
			} else {
				return new ResponseEntity<Integer>(HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Integer>(HttpStatus.UNAUTHORIZED);
		}

	}

}
