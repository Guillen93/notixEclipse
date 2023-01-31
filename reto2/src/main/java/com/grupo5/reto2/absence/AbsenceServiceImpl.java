package com.grupo5.reto2.absence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.student.Student;
import com.grupo5.reto2.student.StudentRepository;
import com.grupo5.reto2.subject.Subject;
import com.grupo5.reto2.subject.SubjectRepository;

@Service
public class AbsenceServiceImpl implements AbsenceService {

	@Autowired
	AbsenceRepository absenceRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Iterable<AbsenceServiceModel> getAllAbsences() throws NotContentException {
		Iterable<Absence> absences = absenceRepository.findAll();

		List<AbsenceServiceModel> response = new ArrayList<AbsenceServiceModel>();

		if (absences == null || absences.iterator().hasNext() == false) {
			throw new NotContentException("No hay ediciones de ese grado");
		}

		for (Absence absence : absences) {
			response.add(new AbsenceServiceModel(absence.getId(), absence.getStudentDni(), absence.getSubjectId(),
					absence.getId().getFoul().toString(), absence.isJustified()

			));
		}
		return response;
	}

	@Override
	public Iterable<AbsenceServiceModel> getAllAbsencesByStudent(String studentDni) throws NotContentException {

		Iterable<Absence> absences = absenceRepository.findByStudentDni(studentDni);

		List<AbsenceServiceModel> response = new ArrayList<AbsenceServiceModel>();

		if (absences == null || absences.iterator().hasNext() == false) {
			throw new NotContentException("No existe el estudiante");
		}

		for (Absence absence : absences) {
			response.add(new AbsenceServiceModel(absence.getId(), absence.getStudentDni(), absence.getSubjectId(),
					absence.getId().getFoul().toString(), absence.isJustified()));
		}
		return response;
	}

	@Override
	public AbsenceServiceModel getAbsencesByStudentDniAndSubjectId(String studentDni, Integer subjectId)
			throws NotContentException {

		Absence absence = absenceRepository.findByStudentDniAndSubjectId(studentDni, subjectId);

		if (absence == null) {
			throw new NotContentException("No existe el estudiante");
		} else {

			AbsenceServiceModel response = new AbsenceServiceModel(absence.getId(), absence.getStudentDni(),
					absence.getSubjectId(), absence.getId().getFoul().toString(), absence.isJustified());

			return response;
		}
	}

	@Override
	public AbsenceServiceModel createAbsence(AbsencePostRequest absencePostRequest)
			throws ConflictException, NotContentException {
		Student student = studentRepository.findByStudentDni(absencePostRequest.getStudentDni());
		Subject subject = subjectRepository.findBySubjectId(absencePostRequest.getSubjectId());

		if (student == null || subject == null) {
			throw new NotContentException(
					"El estudiante no se encuentra en el sistema por lo que no se puede crear una nota para el mismo");
		} else {
			Absence absence = absenceRepository.findByStudentDniAndSubjectIdAndFoul(absencePostRequest.getStudentDni(),
					absencePostRequest.getSubjectId(), Date.valueOf(absencePostRequest.getFoul()));
			if (absence != null) {

				throw new ConflictException("La falta ya esta registrado");

			} else {
				Date date = Date.valueOf(absencePostRequest.getFoul());

				AbsenceId absenceId = new AbsenceId();

				absenceId.setStudentDni(absencePostRequest.getStudentDni());
				absenceId.setSubjectId(absencePostRequest.getSubjectId());
				absenceId.setFoul(date);

				absence = new Absence(absenceId, student, absencePostRequest.getStudentDni(), subject,
						absencePostRequest.getSubjectId(), date, absencePostRequest.isJustified());

				absence = absenceRepository.save(absence);

				AbsenceServiceModel response = new AbsenceServiceModel(absence.getId(), absence.getStudentDni(),
						absence.getSubjectId(), absence.getId().getFoul().toString(), absence.isJustified());
				return response;
			}
		}
	}

	@Override
	public AbsenceServiceModel updateAbsence(String studentDni, Integer subjectId, String dateString,
			AbsencePostRequest absencePostRequest) throws NotContentException {

		Date date = Date.valueOf(dateString);
		Absence absence = absenceRepository.findByStudentDniAndSubjectIdAndFoul(studentDni, subjectId, date);

		if (absence == null) {

			throw new NotContentException("El estudiante ya esta registrado");

		} else {

			if (absencePostRequest.isJustified() != absence.isJustified()) {
				if (absencePostRequest.isJustified() == true) {
					absence.setJustified(true);

				} else {
					absence.setJustified(false);
				}

			}

			absence = absenceRepository.save(absence);

			AbsenceServiceModel response = new AbsenceServiceModel(absence.getId(), studentDni, subjectId,
					absence.getId().getFoul().toString(), absence.isJustified());
			return response;
		}
	}

	@Override
	public Integer deleteAbsence(String studentDni, Integer subjectId, Date date) {

		Integer response = absenceRepository.deleteByStudentDniAndSubjectIdAndFoul(studentDni, subjectId, date);
		return response;
	}

	@Override
	public Iterable<AbsenceServiceModel> getAAbsencesByStudentDniAndJustified(String studentDni)
			throws NotContentException {
		Iterable<Absence> absences = absenceRepository.findByStudentDniAndJustified(studentDni, true);

		List<AbsenceServiceModel> response = new ArrayList<AbsenceServiceModel>();

		if (absences == null || absences.iterator().hasNext() == false) {
			throw new NotContentException("No existen faltas para ese  estudiante");
		}

		for (Absence absence : absences) {
			response.add(new AbsenceServiceModel(absence.getId(), absence.getStudentDni(), absence.getSubjectId(),
					absence.getId().getFoul().toString(), absence.isJustified()));
		}
		return response;
	}

}
