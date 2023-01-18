package com.grupo5.reto2.role;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface RoleService {

	Iterable<RoleServiceModel> getAllRoles() throws NotContentException;
	
	RoleServiceModel getRoleById(Integer roleId) throws NotContentException;
	
	RoleServiceModel createRole(RolePostRequest rolePostRequest) throws NotContentException, ConflictException;

	RoleServiceModel updateRole(Integer roleId, RolePostRequest rolePostRequest) throws NotContentException;

	Boolean deleteRole(Integer roleId) throws NotContentException;
}
