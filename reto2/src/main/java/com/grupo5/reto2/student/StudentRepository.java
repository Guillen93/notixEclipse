
package com.grupo5.reto2.student;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student findByStudentDni(String studentDNI);
	
	Boolean existsByStudentDni(String studentDNI);
	
	@Transactional
	@Modifying
	Integer deleteByStudentDni(String studentDNI);
}
