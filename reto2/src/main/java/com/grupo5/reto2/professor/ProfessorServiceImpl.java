package com.grupo5.reto2.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public Iterable<Professor> findAll() {
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
	public Boolean createProfessor(ProfessorRequest professorRequest) {
		
		Professor professor = professorRepository.findByProfessorDni(professorRequest.getProfessorDni());
		Boolean response = false;
		
		if (professor == null) {
			professor = new Professor(professorRequest.getProfessorDni(), professorRequest.getName(),
					professorRequest.getSurname(), professorRequest.getNationality(), professorRequest.getEmail(),
					professorRequest.getAddres(), professorRequest.getPhoto());
			professorRepository.save(professor);
			response = true;
		}
		return response;
		
	}

	@Override
	public Boolean updateProfessor(String professorDni, ProfessorRequest professorRequest) {

		Professor professor = professorRepository.findByProfessorDni(professorDni);
		Boolean response = false;
		
		if (professor != null) {
			
			if (professorRequest.getProfessorDni() != null) {
				professor.setProfessorDni(professorRequest.getProfessorDni());
			}
			if (professorRequest.getName() != null) {
				professor.setName(professorRequest.getName());
			}
			if (professorRequest.getSurname() != null) {
				professor.setSurname(professorRequest.getSurname());
			}
			if (professorRequest.getNationality() != null) {
				professor.setNationality(professorRequest.getNationality());
			}
			if (professorRequest.getEmail() != null) {
				professor.setEmail(professorRequest.getEmail());
			}
			if (professorRequest.getAddres() != null) {
				professor.setAddres(professorRequest.getAddres());
			}
			if (professorRequest.getPhoto() != null) {
				professor.setPhoto(professorRequest.getPhoto());
			}

			professorRepository.save(professor);
			response = true;
		}
		return response;
	}

	@Override
	public Boolean deleteByProfessorDni(String professorDni) {
		
		Professor professor = professorRepository.findByProfessorDni(professorDni);
		Boolean response = false;
		
		if (professor != null) {
			professorRepository.deleteByProfessorDni(professorDni);
			response = true;
		} 
		return response;
	}

}