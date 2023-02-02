package com.grupo5.reto2.student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.professor.Professor;
import com.grupo5.reto2.professor.ProfessorRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public Iterable<StudentServiceModel> findAllStudents() throws NotContentException, IOException {
		Iterable<Student> students = studentRepository.findAll();

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {
			String photoBase = "";
			if (student.getPhoto() != null && student.getPhoto().length() != 0) {

				File file = new File(student.getPhoto());
				byte[] fileContent = Files.readAllBytes(file.toPath());
				photoBase = Base64.getEncoder().encodeToString(fileContent);

			}
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					photoBase));
		}

		return response;
	}

	@Override
	public StudentServiceModel findByStudentDni(String studentDNI) throws NotContentException, IOException {

		Student student = studentRepository.findByStudentDni(studentDNI);
		if (student == null) {
			throw new NotContentException("No existe el estudiante");
		}
		String photoBase = "";
		if (student.getPhoto() != null && student.getPhoto().length() != 0) {

			File file = new File(student.getPhoto());
			byte[] fileContent = Files.readAllBytes(file.toPath());
			photoBase = Base64.getEncoder().encodeToString(fileContent);

		}

		StudentServiceModel response = new StudentServiceModel(student.getStudentDni(), student.getName(),
				student.getSurname(), student.getBornDate().toString(), student.getNationality(), student.getEmail(),
				student.getPhone(), photoBase);

		return response;
	}

	@Override
	public StudentServiceModel createStudent(StudentPostRequest studentPostRequest)
			throws ConflictException, NotContentException, IOException {

		Student student = studentRepository.findByStudentDni(studentPostRequest.getStudentDni());

		Professor professor = professorRepository.findByProfessorDni(studentPostRequest.getStudentDni());

		if (student != null || professor != null) {

			throw new ConflictException("Usuario ya registrado");

		} else {
			String outputFile="";
			if(studentPostRequest.getPhoto()!=null) {
			String extensionArchivo = detectMimeType(studentPostRequest.getPhoto());
			String fileName = studentPostRequest.getStudentDni() + extensionArchivo;
			outputFile = "src/main/resources/static/images/" + fileName;

			byte[] decodedImg = Base64.getDecoder().decode(studentPostRequest.getPhoto());
			Path destinatioFile = Paths.get(outputFile);
			Files.write(destinatioFile, decodedImg);
			}
			student = new Student(studentPostRequest.getStudentDni(), studentPostRequest.getName(),
					studentPostRequest.getSurname(), Date.valueOf(studentPostRequest.getBornDate()),
					studentPostRequest.getNationality(), studentPostRequest.getEmail(), studentPostRequest.getPhone(),
					outputFile);

			student = studentRepository.save(student);

			StudentServiceModel response = new StudentServiceModel(student.getStudentDni(), student.getName(),
					student.getSurname(), student.getBornDate().toString(), student.getNationality(),
					student.getEmail(), student.getPhone(), student.getPhoto());
			return response;
		}

	}

	@Override
	public StudentServiceModel updateStudent(String studentDNI, StudentPostRequest studentPostRequest)
			throws NotContentException {

		Student student = studentRepository.findByStudentDni(studentDNI);

		if (student == null) {
			throw new NotContentException("No existe el estudiante");
		} else {

			if (studentPostRequest.getStudentDni() != null) {
				student.setStudentDni(studentPostRequest.getStudentDni());
			}
			if (studentPostRequest.getName() != null) {
				student.setName(studentPostRequest.getName());
			}
			if (studentPostRequest.getSurname() != null) {
				student.setSurname(studentPostRequest.getSurname());
			}
			if (studentPostRequest.getBornDate() != null) {
				student.setBornDate(Date.valueOf(studentPostRequest.getBornDate()));
			}
			if (studentPostRequest.getNationality() != null) {
				student.setNationality(studentPostRequest.getNationality());
			}
			if (studentPostRequest.getEmail() != null) {
				student.setEmail(studentPostRequest.getEmail());
			}
			if (studentPostRequest.getPhone() != null) {
				student.setPhone(studentPostRequest.getPhone());
			}

			student = studentRepository.save(student);

			StudentServiceModel response = new StudentServiceModel(studentDNI, student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					student.getPhoto());

			return response;
		}

	}

	@Override
	public Integer deleteByStudentDni(String studentDNI) {

		return studentRepository.deleteByStudentDni(studentDNI);
	}

	@Override
	public Iterable<StudentServiceModel> getStudentsByGradeEdition(Integer GradeEditionId)
			throws NotContentException, IOException {

		Iterable<Student> students = studentRepository.findStudentByPromotionsGradeEditionId(GradeEditionId);

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {
			String photoBase = "";
			if (student.getPhoto() != null && student.getPhoto().length() != 0) {

				File file = new File(student.getPhoto());
				byte[] fileContent = Files.readAllBytes(file.toPath());
				photoBase = Base64.getEncoder().encodeToString(fileContent);

			}
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					photoBase));
		}

		return response;

	}

	@Override
	public Iterable<StudentServiceModel> getStudentsbyProfessorDni(String professorDNI)
			throws NotContentException, IOException {

		Iterable<Student> students = studentRepository.findStudentByProfessorDni(professorDNI);

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {

			String photoBase = "";
			if (student.getPhoto() != null && student.getPhoto().length() != 0) {

				File file = new File(student.getPhoto());
				byte[] fileContent = Files.readAllBytes(file.toPath());
				photoBase = Base64.getEncoder().encodeToString(fileContent);

			}
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					photoBase));
		}

		return response;

	}

	@Override
	public Iterable<StudentServiceModel> getStudentsBySubjectId(Integer subjectId)
			throws NotContentException, IOException {

		Iterable<Student> students = studentRepository.findStudentBySubjectId(subjectId);

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {

			String photoBase = "";
			if (student.getPhoto() != null && student.getPhoto().length() != 0) {

				File file = new File(student.getPhoto());
				byte[] fileContent = Files.readAllBytes(file.toPath());
				photoBase = Base64.getEncoder().encodeToString(fileContent);

			}
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					photoBase));
		}
		return response;
	}

	@Override
	public Integer createPromotion(PromotionPostRequest promotionPostRequest)
			throws ConflictException, NotContentException {

		Integer exists = studentRepository.findPromotionByStudentDniAndGradeEditionId(
				promotionPostRequest.getStudentDni(), promotionPostRequest.getGradeEditionId());

		if (exists != 0) {

			throw new ConflictException("Ya existe una promocion para ese dni con esa edicion de grado.");
		} else {
			Integer response = studentRepository.savePromotions(promotionPostRequest.getStudentDni(),
					promotionPostRequest.getGradeEditionId());

			return response;
		}

	}

	@Override
	public Iterable<StudentServiceModel> findStudentBySubjectIdAndProfessorDni(Integer Subject_id, String professorDNI)
			throws NotContentException, IOException {

		Iterable<Student> students = studentRepository.findStudentBySubjectIdAndProfessorDni(Subject_id, professorDNI);

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {

			String photoBase = "";
			if (student.getPhoto() != null && student.getPhoto().length() != 0) {

				File file = new File(student.getPhoto());
				byte[] fileContent = Files.readAllBytes(file.toPath());
				photoBase = Base64.getEncoder().encodeToString(fileContent);

			}
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					photoBase));
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
