package com.grupo5.reto2.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.role.Role;
import com.grupo5.reto2.role.RoleRepository;
import com.grupo5.reto2.security.HashPasswordEncoder;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Iterable<UserServiceModel> GetUsers() throws NotContentException {
		Iterable<User> users = userRepository.findAll();
		List<UserServiceModel> response = new ArrayList<UserServiceModel>();

		if (users == null || users.iterator().hasNext() == false) {
			throw new NotContentException("No hay usuarios ");
		}

		for (User user : users) {
			response.add(new UserServiceModel(user.getDni(), user.isEnabled(), user.getRoles()));
		}

		return response;
	}

	@Override
	public UserServiceModel GetUsersBydni(String userDni) throws NotContentException {
		try {

			User user = userRepository.findByDni(userDni).get();

			UserServiceModel response = new UserServiceModel(user.getDni(), user.isEnabled(), user.getRoles());
			return response;
		} catch (NoSuchElementException e) {
			throw new NotContentException("No hay usuarios ");
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByDni(username)
				.orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
	}

	@Override
	public User signUp(UserRequest request) throws UserException, ConflictException {
		try {

			User user = new User(request.getDni(), request.getPassword());

			Boolean response = userRepository.existsByDni(user.getDni());

			if (response) {
				throw new ConflictException("Ya existe el usuario");
			} else {

				HashPasswordEncoder passwordEncoder = new HashPasswordEncoder();
				String password = passwordEncoder.encode(user.getPassword());
				user.setPassword(password);

//				Role userRole = roleRepository.findByRole(Rol.Student.name()).get();
				Role userRole = roleRepository.findById(request.getRoleId()).get();
				Set<Role> roles = new HashSet<>();
				roles.add(userRole);

				//user.setEnabled(true);
				user.setRoles(roles);

				return userRepository.save(user);

			}

		} catch (DataAccessException e) {
			throw new UserException(e.getMessage());

		} catch (NoSuchElementException e) {
			throw new ConflictException("el usuario ya existe");
		}

	}

	@Override
	public Boolean deleteUser(String username) throws NotContentException {
		Boolean response = userRepository.existsByDni(username);

		if (!response) {
			throw new NotContentException("No existe el usuario");
		} else {
			userRepository.deleteByDni(username);
		}

		return response;
	}

	@Override
	public UserServiceModel addRoles(String userDni, UserRequest request) throws NotContentException {

		User user = userRepository.findByDni(userDni)
				.orElseThrow(() -> new NotContentException("No existe ese usuario"));

		user = userRepository.save(user);

		Role userRole = roleRepository.findById(request.getRoleId()).get();
		Set<Role> roles = new HashSet<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);

		UserServiceModel response = new UserServiceModel(user.getDni(), user.isEnabled(), user.getRoles());

		return response;

	}

	@Override
	public UserServiceModel updateUser(String username, UserRequest request) throws NotContentException {

		User user = userRepository.findByDni(username).orElseThrow(() -> new NotContentException("No existe ese usuario"));

			if (request.getPassword() == null) {
				HashPasswordEncoder passwordEncoder = new HashPasswordEncoder();
				String password = passwordEncoder.encode(request.getPassword());
				user.setPassword(password);

			}
			if (request.isEnabled()!=user.isEnabled()) {

				user.setEnabled(request.isEnabled());
			}

			user = userRepository.save(user);

			UserServiceModel response = new UserServiceModel(user.getDni(), user.isEnabled(), user.getRoles());

			return response;

		
	}

}