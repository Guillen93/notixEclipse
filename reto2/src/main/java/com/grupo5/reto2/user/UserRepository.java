package com.grupo5.reto2.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import jakarta.transaction.Transactional;


public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findByDni(String DNI);
	
	Boolean existsByDni(String DNI);
	@Transactional
	@Modifying
	void deleteByDni(@Param("dni") String dni);
	
	@Transactional
	@Query(value="select * from user where is_enabled = 0;",nativeQuery = true)
	Iterable<User> findNotEnabledUsers();

	@Transactional
	@Query(value="select * from user where dni in (select user_dni from user_role where role_id !=1)",nativeQuery = true)
	Iterable<User> findUsersWithoutAdminRole();

	

}

