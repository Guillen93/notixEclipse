package com.grupo5.reto2.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Iterable<RoleServiceModel> getAllRoles() throws NotContentException {
		Iterable<Role> roles = roleRepository.findAll();

		List<RoleServiceModel> response = new ArrayList<RoleServiceModel>();

		if (roles == null || roles.iterator().hasNext() == false) {
			throw new NotContentException("No hay roles ");
		} else {

			for (Role role : roles) {
				response.add(new RoleServiceModel(role.getRoleID(), role.getRole()));
			}

			return response;

		}

	}

	@Override
	public RoleServiceModel getRoleById(Integer roleId) throws NotContentException {

		Role role = roleRepository.findById(roleId).get();

		if (role == null) {
			throw new NotContentException("No hay rol con esa id ");
		} else {

			RoleServiceModel response = new RoleServiceModel(role.getRoleID(), role.getRole());

			return response;

		}

	}

	@Override
	public RoleServiceModel createRole(RolePostRequest rolePostRequest) throws NotContentException, ConflictException {

		Role role = new Role(rolePostRequest.getRole());

		role = roleRepository.save(role);

		RoleServiceModel response = new RoleServiceModel(role.getRoleID(), role.getRole());

		return response;

	}

	@Override
	public RoleServiceModel updateRole(Integer roleId, RolePostRequest rolePostRequest) throws NotContentException {

		Role role = roleRepository.findById(roleId).get();

		if (role == null) {
			throw new NotContentException("No existe el rol con esa ID");
		} else {

			if (rolePostRequest.getRole() != null) {
				role.setRole(rolePostRequest.getRole());
			}

			role.setRoleID(roleId);

			role = roleRepository.save(role);

			RoleServiceModel response = new RoleServiceModel(role.getRoleID(), role.getRole());

			return response;
		}

	}

	@Override
	public Boolean deleteRole(Integer roleId) throws NotContentException {

		Boolean response = roleRepository.existsById(roleId);

		if (!response) {
			throw new NotContentException("No existe ese rol");
		} else {
			roleRepository.deleteById(roleId);
		}

		return response;
	}

}
