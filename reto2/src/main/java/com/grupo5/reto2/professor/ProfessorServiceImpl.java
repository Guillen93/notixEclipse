package com.grupo5.reto2.professor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Iterable<ProfessorResponse> findAll() throws NotContentException, IOException {

		Iterable<Professor> professors = professorRepository.findAll();

		List<ProfessorResponse> response = new ArrayList<ProfessorResponse>();

		if (professors == null || professors.iterator().hasNext() == false) {
			throw new NotContentException("No hay professores ");
		}

		for (Professor professor : professors) {
			String photoBase = "";

			if (professor.getPhoto() != null || professor.getPhoto().isEmpty() == false) {

				File file = new File(professor.getPhoto());
				byte[] fileContent = Files.readAllBytes(file.toPath());
				photoBase = Base64.getEncoder().encodeToString(fileContent);

			}
			response.add(new ProfessorResponse(professor.getProfessorDni(), professor.getName(), professor.getSurname(),
					professor.getEmail(), photoBase, professor.getNationality(), professor.getAddres()));
		}

		return response;
	}

	@Override
	public ProfessorResponse findByProfessorDni(String professorDni) throws NotContentException, IOException {

		Professor professor = professorRepository.findByProfessorDni(professorDni);

		if (professor == null) {
			throw new NotContentException("No hay professores ");
		}

		String photoBase = "";

		if (professor.getPhoto() != null) {

			File file = new File(professor.getPhoto());
			byte[] fileContent = Files.readAllBytes(file.toPath());
			photoBase = Base64.getEncoder().encodeToString(fileContent);

		}

		ProfessorResponse response = new ProfessorResponse(professor.getProfessorDni(), professor.getName(),
				professor.getSurname(), professor.getEmail(), photoBase, professor.getNationality(),
				professor.getAddres());
		return response;

	}

	@Override
	public ProfessorResponse createProfessor(ProfessorRequest professorRequest)
			throws ConflictException, NotContentException, IOException {

		Student student = studentRepository.findByStudentDni(professorRequest.getProfessorDni());

		Professor professor = professorRepository.findByProfessorDni(professorRequest.getProfessorDni());

		if (student != null || professor != null) {

			throw new ConflictException("Usuario ya registrado");

		} else {
			
			String extensionArchivo = detectMimeType(professorRequest.getPhoto());
			String fileName = professorRequest.getProfessorDni() + extensionArchivo;
			String outputFile = "src/main/resources/static/images/" + fileName;

			byte[] decodedImg = Base64.getDecoder().decode(professorRequest.getPhoto());
			Path destinatioFile = Paths.get(outputFile);
			Files.write(destinatioFile, decodedImg);

			professor = new Professor(professorRequest.getProfessorDni(), professorRequest.getName(),
					professorRequest.getSurname(), professorRequest.getNationality(), professorRequest.getEmail(),
					professorRequest.getAddres(), outputFile);
			
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
	public ProfessorResponse findTutorByGradeEditionId(Integer gradeEditionId) throws NotContentException, IOException {

		Professor professor = professorRepository.findProfessorbyGradeEditionId(gradeEditionId);

		if (professor == null) {
			throw new NotContentException("No hay tutor para esa edicion de grado o no existe esa edicion de grado");
		}

		String photoBase = "";

		if (professor.getPhoto() != null) {

			File file = new File(professor.getPhoto());
			byte[] fileContent = Files.readAllBytes(file.toPath());
			photoBase = Base64.getEncoder().encodeToString(fileContent);

		}

		ProfessorResponse response = new ProfessorResponse(professor.getProfessorDni(), professor.getName(),
				professor.getSurname(), professor.getEmail(), photoBase, professor.getNationality(),
				professor.getAddres());
		return response;
	}

	@Override
	public Iterable<ProfessorResponse> getProfessorByStudentDni(String studentDni) throws NotContentException, IOException {

		Iterable<Professor> professors = professorRepository.findProfessorsByStudentDni(studentDni);

		List<ProfessorResponse> response = new ArrayList<ProfessorResponse>();

		if (professors == null || professors.iterator().hasNext() == false) {
			throw new NotContentException("No hay professores ");
		}

		for (Professor professor : professors) {
			String photoBase = "";

			if (professor.getPhoto() != null) {

				File file = new File(professor.getPhoto());
				byte[] fileContent = Files.readAllBytes(file.toPath());
				photoBase = Base64.getEncoder().encodeToString(fileContent);

			}
			response.add(new ProfessorResponse(professor.getProfessorDni(), professor.getName(), professor.getSurname(),
					professor.getEmail(), photoBase, professor.getNationality(), professor.getAddres()));
		}

		return response;
	}

	
	private String detectMimeType(String base64Content) {

		HashMap<String, String> signatures = new HashMap<String, String>();
		signatures.put("JVBERi0", ".pdf");
		signatures.put("R0lGODdh", ".gif");
		signatures.put("R0lGODdh", ".gif");
		signatures.put("iVBORw0KGgo", ".png");
		signatures.put("/9j/", ".jpg");
		String response = "";

		for (Map.Entry<String, String> entry : signatures.entrySet()) {

			String key = entry.getKey();

			if (base64Content.indexOf(key) == 0) {

				response = entry.getValue();

			}

		}

		return response;

	}
	


}