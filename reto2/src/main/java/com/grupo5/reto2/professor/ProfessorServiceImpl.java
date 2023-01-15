package com.grupo5.reto2.professor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public Iterable<ProfessorResponse> findAll() throws NotContentException {
		//return professorRepository.findAll();
		
		Iterable<Professor> professors = professorRepository.findAll();

		List<ProfessorResponse> response = new ArrayList<ProfessorResponse>();
		
		if (professors == null) {
			throw new NotContentException("No hay professores ");
		}
		
		for (Professor professor : professors) {
			response.add(new ProfessorResponse(
					professor.getProfessorDni(),
					professor.getName(),
					professor.getSurname(),
					professor.getEmail(),
					professor.getPhoto()
					));
			}

		return response;
	}

	@Override
	public ProfessorResponse findByProfessorDni(String professorDni) throws NotContentException {

		Professor professor = professorRepository.findByProfessorDni(professorDni);
		
		
		if (professor == null) {
			throw new NotContentException("No hay professores ");
		}

		ProfessorResponse response = new ProfessorResponse(
				professor.getProfessorDni(),
				professor.getName(),
				professor.getSurname(),
				professor.getEmail(),
				professor.getPhoto()
				);
		return response;

	}

	@Override
	public ProfessorResponse createProfessor(ProfessorRequest professorRequest) throws ConflictException {
		
		Professor professor = professorRepository.findByProfessorDni(professorRequest.getProfessorDni());
		
		if (professor != null) {

			throw new ConflictException("El profesor ya esta registrado");

		} else {
			
			professor = new Professor(
					professorRequest.getProfessorDni(),
					professorRequest.getName(),
					professorRequest.getSurname(),
					professorRequest.getNationality(), 
					professorRequest.getEmail(),
					professorRequest.getAddres(), 
					professorRequest.getPhoto()
			);
			professor = professorRepository.save(professor);
			
			ProfessorResponse response = new ProfessorResponse(
					professor.getProfessorDni(),
					professor.getName(),
					professor.getSurname(),
					professor.getEmail(),
					professor.getPhoto()
					);
			
			return response;
			
		}
	}

	@Override
	public ProfessorResponse updateProfessor(String professorDni, ProfessorRequest professorRequest) throws NotContentException {

		Professor professor = professorRepository.findByProfessorDni(professorDni);
		
		if (professor == null) {
			throw new NotContentException("No existe el profesor");
		}else {
			
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

			professor = professorRepository.save(professor);
			
			
			ProfessorResponse response = new ProfessorResponse(
					professor.getProfessorDni(),
					professor.getName(),
					professor.getSurname(),
					professor.getEmail(),
					professor.getPhoto()
					);
			return response;
		}
		
	}

	@Override
	public Integer deleteByProfessorDni(String professorDni) {
		return professorRepository.deleteByProfessorDni(professorDni);
	}

}