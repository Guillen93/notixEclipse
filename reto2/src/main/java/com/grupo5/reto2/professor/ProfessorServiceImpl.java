package com.grupo5.reto2.professor;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Object findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}