package com.grupo5.reto2.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public Iterable<Professor> findAll() {
		// TODO Auto-generated method stub
		return professorRepository.findAll();
	}

	@Override
	public ProfessorResponse findByProfessorDni(String professorDni) {

		Professor professor = professorRepository.findByProfessorDni(professorDni);

		ProfessorResponse response = new ProfessorResponse(professor.getProfessorDni(), professor.getName(),
				professor.getSurname(), professor.getEmail(), professor.getPhoto());
		return response;

	}

	@Override
	public ResponseEntity<Integer> createProfessor(ProfessorRequest professorRequest) {
		Professor response = new Professor(professorRequest.getProfessorDni(), professorRequest.getName(),
				professorRequest.getSurname(), professorRequest.getNationality(), professorRequest.getEmail(),
				professorRequest.getAddres(), professorRequest.getPhoto());

		professorRepository.save(response);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> updateProfessor(String professorDni, ProfessorRequest professorRequest) {

		Professor response = professorRepository.findByProfessorDni(professorDni);

		if (response == null) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		} else {
			
			if (professorRequest.getProfessorDni() != null) {
				response.setProfessorDni(professorRequest.getProfessorDni());
			}
			if (professorRequest.getName() != null) {
				response.setName(professorRequest.getName());
			}
			if (professorRequest.getSurname() != null) {
				response.setSurname(professorRequest.getSurname());
			}
			if (professorRequest.getNationality() != null) {
				response.setNationality(professorRequest.getNationality());
			}
			if (professorRequest.getEmail() != null) {
				response.setEmail(professorRequest.getEmail());
			}
			if (professorRequest.getAddres() != null) {
				response.setAddres(professorRequest.getAddres());
			}
			if (professorRequest.getPhoto() != null) {
				response.setPhoto(professorRequest.getPhoto());
			}

			professorRepository.save(response);
			return new ResponseEntity<Integer>(HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Integer> deleteByProfessorDni(String professorDni) {
		return new ResponseEntity<Integer>(professorRepository.deleteByProfessorDni(professorDni), HttpStatus.OK);
	}

}