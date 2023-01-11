
package com.grupo5.reto2.student;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.grupo5.reto2.exceptions.NotContentException;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student findByStudentDni(String studentDNI) throws NotContentException;
	
	Boolean existsByStudentDni(String studentDNI);
	
	@Transactional
	@Modifying
	Integer deleteByStudentDni(String studentDNI);
}
