
package com.grupo5.reto2.student;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.grupo5.reto2.exceptions.NotContentException;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student findByStudentDni(String studentDNI) throws NotContentException;
	
	Boolean existsByStudentDni(String studentDNI);
	
	@Transactional
	@Modifying
	Integer deleteByStudentDni(String studentDNI);
	
	@Transactional
	@Query(value="select * from student where student_dni in (select student_dni from promotion where grade_ed_id = :grade_ed_id);",nativeQuery = true)
	Iterable<Student> findStudentByPromotionsGradeEditionId(@Param("grade_ed_id") Integer grade_ed_id);
	
	@Transactional
	@Modifying
	@Query(value="Insert into promotion (student_dni,grade_ed_id) values (:student_dni, :grade_ed_id)",nativeQuery = true)
	public Integer savePromotions(@Param("student_dni") String student_dni , @Param("grade_ed_id") Integer grade_ed_id);
	
	
	@Transactional
	@Query(value="select count(*) from promotion where student_dni = :student_dni and grade_ed_id = :grade_ed_id",nativeQuery = true)
	Integer findPromotionByStudentDniAndGradeEditionId(@Param("student_dni") String student_dni , @Param("grade_ed_id") Integer grade_ed_id);
	
	
	@Transactional
	@Query(value="select * from student where student_dni in (select student_dni from note where subject_id in (select subject_id from subject where professor_dni = :professor_dni));",nativeQuery = true)
	Iterable<Student> findStudentByProfessorDni(@Param("professor_dni") String professor_dni);
	
	
	@Transactional
	@Query(value="select * from student where student_dni in (select student_dni from note where subject_id = :subject_id)",nativeQuery = true)
	Iterable<Student> findStudentBySubjectId(@Param("subject_id") Integer subject_id);
	
}
