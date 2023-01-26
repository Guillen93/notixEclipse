package com.grupo5.reto2.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
	public Iterable<StudentServiceModel> findAllStudents() throws NotContentException {
		Iterable<Student> students = studentRepository.findAll();

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					student.getPhoto()));
		}

		return response;
	}

	@Override
	public StudentServiceModel findByStudentDni(String studentDNI) throws NotContentException {

		Student student = studentRepository.findByStudentDni(studentDNI);
		if (student == null) {
			throw new NotContentException("No existe el estudiante");
		}

		StudentServiceModel response = new StudentServiceModel(student.getStudentDni(), student.getName(),
				student.getSurname(), student.getBornDate().toString(), student.getNationality(), student.getEmail(),
				student.getPhone(), student.getPhoto());

		return response;
	}

	@Override
	public StudentServiceModel createStudent(StudentPostRequest studentPostRequest)
			throws ConflictException, NotContentException {

		Student student = studentRepository.findByStudentDni(studentPostRequest.getStudentDni());

		Professor professor = professorRepository.findByProfessorDni(studentPostRequest.getStudentDni());

		if (student != null || professor != null) {

			throw new ConflictException("Usuario ya registrado");

		} else {

			student = new Student(studentPostRequest.getStudentDni(), studentPostRequest.getName(),
					studentPostRequest.getSurname(), Date.valueOf(studentPostRequest.getBornDate()),
					studentPostRequest.getNationality(), studentPostRequest.getEmail(), studentPostRequest.getPhone(),
					studentPostRequest.getPhoto());

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
			if (studentPostRequest.getPhoto() != null) {
				student.setPhoto(studentPostRequest.getPhoto());
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
	public Iterable<StudentServiceModel> getStudentsByGradeEdition(Integer GradeEditionId) throws NotContentException {

		Iterable<Student> students = studentRepository.findStudentByPromotionsGradeEditionId(GradeEditionId);

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		} else {
			for (Student student : students) {
				response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
						student.getBornDate().toString(), student.getNationality(), student.getEmail(),
						student.getPhone(), student.getPhoto()));
			}

			return response;
		}

	}

	@Override
	public Iterable<StudentServiceModel> getStudentsbyProfessorDni(String professorDNI) throws NotContentException {

		Iterable<Student> students = studentRepository.findStudentByProfessorDni(professorDNI);

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					student.getPhoto()));
		}

		return response;

	}

	@Override
	public Iterable<StudentServiceModel> getStudentsBySubjectId(Integer subjectId) throws NotContentException {

		Iterable<Student> students = studentRepository.findStudentBySubjectId(subjectId);

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();

		if (students == null || students.iterator().hasNext() == false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {
			response.add(new StudentServiceModel(student.getStudentDni(), student.getName(), student.getSurname(),
					student.getBornDate().toString(), student.getNationality(), student.getEmail(), student.getPhone(),
					student.getPhoto()));
		}

		return response;
	}

	@Override
	public Integer createPromotion(PromotionPostRequest promotionPostRequest)
			throws ConflictException, NotContentException {

		Integer response = studentRepository.savePromotions(promotionPostRequest.getStudentDni(),
				promotionPostRequest.getGradeEditionId());

		return response;
	}

}
