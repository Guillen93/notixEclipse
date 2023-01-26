package com.grupo5.reto2.professor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.student.Student;
import com.grupo5.reto2.student.StudentRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Iterable<ProfessorResponse> findAll() throws NotContentException {

		Iterable<Professor> professors = professorRepository.findAll();

		List<ProfessorResponse> response = new ArrayList<ProfessorResponse>();

		if (professors == null || professors.iterator().hasNext() == false) {
			throw new NotContentException("No hay professores ");
		}

		for (Professor professor : professors) {
			response.add(new ProfessorResponse(professor.getProfessorDni(), professor.getName(), professor.getSurname(),
					professor.getEmail(), professor.getPhoto(), professor.getNationality(), professor.getAddres()));
		}

		return response;
	}

	@Override
	public ProfessorResponse findByProfessorDni(String professorDni) throws NotContentException {

		Professor professor = professorRepository.findByProfessorDni(professorDni);

		if (professor == null) {
			throw new NotContentException("No hay professores ");
		}

		ProfessorResponse response = new ProfessorResponse(professor.getProfessorDni(), professor.getName(),
				professor.getSurname(), professor.getEmail(), professor.getPhoto(), professor.getNationality(),
				professor.getAddres());
		return response;

	}

	@Override
	public ProfessorResponse createProfessor(ProfessorRequest professorRequest)
			throws ConflictException, NotContentException {

		Student student = studentRepository.findByStudentDni(professorRequest.getProfessorDni());

		Professor professor = professorRepository.findByProfessorDni(professorRequest.getProfessorDni());

		if (student != null || professor != null) {

			throw new ConflictException("Usuario ya registrado");

		} else {

			professor = new Professor(professorRequest.getProfessorDni(), professorRequest.getName(),
					professorRequest.getSurname(), professorRequest.getNationality(), professorRequest.getEmail(),
					professorRequest.getAddres(), professorRequest.getPhoto());
			professor = professorRepository.save(professor);

			ProfessorResponse response = new ProfessorResponse(professor.getProfessorDni(), professor.getName(),
					professor.getSurname(), professor.getEmail(), professor.getPhoto(), professor.getNationality(),
					professor.getAddres());

			return response;

		}
	}

	@Override
	public ProfessorResponse updateProfessor(String professorDni, ProfessorRequest professorRequest)
			throws NotContentException {

		Professor professor = professorRepository.findByProfessorDni(professorDni);

		if (professor == null) {
			throw new NotContentException("No existe el profesor");
		} else {

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

			ProfessorResponse response = new ProfessorResponse(professorDni, professor.getName(),
					professor.getSurname(), professor.getEmail(), professor.getPhoto(), professor.getNationality(),
					professor.getAddres());
			return response;
		}

	}

	@Override
	public Integer deleteByProfessorDni(String professorDni) {
		return professorRepository.deleteByProfessorDni(professorDni);
	}

	@Override
	public ProfessorResponse findTutorByGradeEditionId(Integer gradeEditionId) throws NotContentException {

		Professor professor = professorRepository.findProfessorbyGradeEditionId(gradeEditionId);

		if (professor == null) {
			throw new NotContentException("No hay tutor para esa edicion de grado o no existe esa edicion de grado");
		}

		ProfessorResponse response = new ProfessorResponse(professor.getProfessorDni(), professor.getName(),
				professor.getSurname(), professor.getEmail(), professor.getPhoto(), professor.getNationality(),
				professor.getAddres());
		return response;
	}

	@Override
	public Iterable<ProfessorResponse> getProfessorByStudentDni(String studentDni) throws NotContentException {

		Iterable<Professor> professors = professorRepository.findProfessorsByStudentDni(studentDni);

		List<ProfessorResponse> response = new ArrayList<ProfessorResponse>();

		if (professors == null || professors.iterator().hasNext() == false) {
			throw new NotContentException("No hay professores ");
		}

		for (Professor professor : professors) {
			response.add(new ProfessorResponse(professor.getProfessorDni(), professor.getName(), professor.getSurname(),
					professor.getEmail(), professor.getPhoto(), professor.getNationality(), professor.getAddres()));
		}

		return response;
	}
}