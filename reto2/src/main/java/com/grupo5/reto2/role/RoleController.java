package com.grupo5.reto2.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

@CrossOrigin
@RestController
@RequestMapping("api")
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping("/roles")
	public ResponseEntity<Iterable<RoleServiceModel>> getRoles() throws NotContentException {

		Iterable<RoleServiceModel> response = roleService.getAllRoles();
		return new ResponseEntity<Iterable<RoleServiceModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/roles/{id}")
	public ResponseEntity<RoleServiceModel> getRolesById(@PathVariable("id") Integer roleId)
			throws NotContentException {

		RoleServiceModel response = roleService.getRoleById(roleId);
		return new ResponseEntity<RoleServiceModel>(response, HttpStatus.OK);
	}

	@PostMapping("/roles")
	public ResponseEntity<RoleServiceModel> createRoles(@RequestBody RolePostRequest rolePostRequest)
			throws NotContentException, ConflictException {

		RoleServiceModel response = roleService.createRole(rolePostRequest);
		return new ResponseEntity<RoleServiceModel>(response, HttpStatus.OK);
	}

	@PutMapping("/roles/{id}")
	public ResponseEntity<RoleServiceModel> updateRoles(@PathVariable("id") Integer roleId,
			@RequestBody RolePostRequest rolePostRequest) throws NotContentException, ConflictException {

		RoleServiceModel response = roleService.updateRole(roleId, rolePostRequest);
		return new ResponseEntity<RoleServiceModel>(response, HttpStatus.OK);
	}

	@DeleteMapping("/roles/{id}")
	public ResponseEntity<Integer> deleteRoles(@PathVariable("id") Integer roleId)
			throws NotContentException, ConflictException {

		roleService.deleteRole(roleId);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

}
