
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
	Iterable<Student> findStudentByPromotionsGradeEditionId(Integer gradeEditionId);
	
	@Modifying
	@Query(value="Insert into promotion (student_dni,grade_ed_id) values (:student_dni, :grade_ed_id)",nativeQuery = true)
	public Integer savePromotions(@Param("student_dni") String student_dni , @Param("grade_ed_id") Integer grade_ed_id);
}
