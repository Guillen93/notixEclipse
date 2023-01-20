package com.grupo5.reto2.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.gradeEdition.GradeEdition;
import com.grupo5.reto2.gradeEdition.GradeEditionRepository;
import com.grupo5.reto2.note.Note;
import com.grupo5.reto2.note.NoteRepository;
import com.grupo5.reto2.note.NoteServiceModel;
import com.grupo5.reto2.professor.Professor;
import com.grupo5.reto2.professor.ProfessorRepository;
import com.grupo5.reto2.subject.Subject;
import com.grupo5.reto2.subject.SubjectRepository;
import com.grupo5.reto2.subject.SubjectServiceModel;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	GradeEditionRepository gradeEditionRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	NoteRepository noteRepository;

	@Override
	public Iterable<StudentServiceModel> findAllStudents() throws NotContentException {
		Iterable<Student> students = studentRepository.findAll();

		List<StudentServiceModel> response = new ArrayList<StudentServiceModel>();
		
		if (students == null || students.iterator().hasNext()==false) {
			throw new NotContentException("No hay estudiantes ");
		}

		for (Student student : students) {
			response.add(new StudentServiceModel(
					student.getStudentDni(),
					student.getName(),
					student.getSurname(),
					student.getBornDate().toString(),
					student.getNationality(),
					student.getEmail(),
					student.getPhone(),
					student.getPhoto()
					));
		}

		return response;
	}

	@Override
	public StudentServiceModel findByStudentDni(String studentDNI) throws NotContentException {

			Student student = studentRepository.findByStudentDni(studentDNI);
			if (student == null) {
				throw new NotContentException("No existe el estudiante");
			}
				
			StudentServiceModel response = new StudentServiceModel(
					student.getStudentDni(),
					student.getName(),
					student.getSurname(),
					student.getBornDate().toString(),
					student.getNationality(),
					student.getEmail(),
					student.getPhone(),
					student.getPhoto()
			);
			
			return response;
	}

	@Override
	public StudentServiceModel createStudent(StudentPostRequest studentPostRequest) throws ConflictException, NotContentException {

		
		Student student = studentRepository.findByStudentDni(studentPostRequest.getStudentDni());
		
		Professor professor = professorRepository.findByProfessorDni(studentPostRequest.getStudentDni());
		
		if (student!=null || professor!=null) {

			throw new ConflictException("Usuario ya registrado");

		} else {

			 student = new Student(
					studentPostRequest.getStudentDni(),
					studentPostRequest.getName(),
					studentPostRequest.getSurname(),
					Date.valueOf(studentPostRequest.getBornDate()),
					studentPostRequest.getNationality(),
					studentPostRequest.getEmail(),
					studentPostRequest.getPhone(),
					studentPostRequest.getPhoto()
					);

			student = studentRepository.save(student);
			
			StudentServiceModel response = new StudentServiceModel(
					student.getStudentDni(),
					student.getName(),
					student.getSurname(),
					student.getBornDate().toString(),
					student.getNationality(),
					student.getEmail(),
					student.getPhone(),
					student.getPhoto()
			);
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
			
			StudentServiceModel response = new StudentServiceModel(
					studentDNI,
					student.getName(),
					student.getSurname(),
					student.getBornDate().toString(),
					student.getNationality(),
					student.getEmail(),
					student.getPhone(),
					student.getPhoto()
			);
			
			return response;
		}

	}

	@Override
	public Integer deleteByStudentDni(String studentDNI) {

		return studentRepository.deleteByStudentDni(studentDNI);
	}

	@Override
	public Iterable<PromotionServiceModel> getStudentsByGradeEdition(Integer GradeEditionId) throws NotContentException {
		
		GradeEdition gradeEdition = gradeEditionRepository.findByGradeEditionId(GradeEditionId);
		
		if(gradeEdition==null) {
			throw new NotContentException("No existe el Grade Edition");
		}else {
			
			Iterable<Student> students =studentRepository.findStudentByPromotionsGradeEditionId(GradeEditionId);
			
			List<PromotionServiceModel> response = new ArrayList<PromotionServiceModel>();
			
			
			
			for (Student student : students) {
				response.add(new PromotionServiceModel(
						student.getStudentDni(),
						student.getName(),
						student.getSurname(),
						student.getBornDate().toString(),
						student.getNationality(),
						student.getEmail(),
						student.getPhone(),
						student.getPhoto(),
						gradeEdition.getFecha().toString()
						));
			}
			
			return response;
			
		}
	
	}

	@Override
	public Iterable<StudentServiceModel> getStudentsbyProfessorDni(String professorDNI) throws NotContentException {
	
		
		Iterable<Subject> subjectsBD = subjectRepository.findByProfessorDni(professorDNI);
		List<SubjectServiceModel> subjects = new ArrayList<SubjectServiceModel>();
		if (subjectsBD == null || subjectsBD.iterator().hasNext()==false) {
			throw new NotContentException("No hay asignatura ");
		}

		for (Subject subject : subjectsBD) {
			
			subjects.add(new SubjectServiceModel(
					subject.getSubjectId(),
					subject.getGradeEdId(),
					subject.getProfessorDni(),
					subject.getName(),
					subject.getDuration()
					));
		}

		
		List<StudentServiceModel> listOfStudents = new ArrayList<StudentServiceModel>();
		
		for(int i = 0;i<subjects.size();i++) {
			Iterable<StudentServiceModel> listOfStudents1 =  getStudentsBySubjectId(subjects.get(i).getSubjectId());

			for (StudentServiceModel student : listOfStudents1) {
				
				
				listOfStudents.add(new StudentServiceModel(
						student.getStudentDni(),
						student.getName(),
						student.getSurname(),
						student.getBornDate().toString(),
						student.getNationality(),
						student.getEmail(),
						student.getPhone(),
						student.getPhoto()
						));
			}
			
		}
		
		if(listOfStudents.size()==0) {
			throw new NotContentException("No hay alumnos para ese profesor ");
		}else {
			return listOfStudents;
		}
		
		
		
	}

	@Override
	public Iterable<StudentServiceModel> getStudentsBySubjectId(Integer subjectId) throws NotContentException {
		
		Iterable<Note> listOfNotesBD = noteRepository.findBySubjectId(subjectId);
		List<NoteServiceModel> listOfNotes = new ArrayList<NoteServiceModel>();
		for (Note note : listOfNotesBD) {
			listOfNotes.add(new NoteServiceModel(
					note.getId(),
					note.getStudentDni(),
					note.getSubjectId(),
					note.getEva1(),
					note.getEva2(),
					note.getEva3(),
					note.getFinal1(),
					note.getFinal2()

			));
		}
		List<StudentServiceModel> listofStudents = new ArrayList<StudentServiceModel>();
		for(int i = 0 ; i<listOfNotes.size();i++){	
			StudentServiceModel studentServiceModel = findByStudentDni(listOfNotes.get(i).getStudentDni());
		
			listofStudents.add(studentServiceModel);
		
		}
		
		
		
		
		return listofStudents;
	}

}
