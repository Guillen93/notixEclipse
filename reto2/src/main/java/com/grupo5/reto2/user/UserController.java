package com.grupo5.reto2.user;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
import com.grupo5.reto2.security.CifradoRSA;
import com.grupo5.reto2.security.JwtTokenUtil;

@CrossOrigin
@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
	AuthenticationManager userManager;

	@Autowired
	JwtTokenUtil jwtUtil;

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<Iterable<UserServiceModel>> GetUsers() throws NotContentException {

		return new ResponseEntity<Iterable<UserServiceModel>>(userService.GetUsers(), HttpStatus.OK);
	}

	@GetMapping("/users/{userDni}")
	public ResponseEntity<UserServiceModel> GetUserbyDni(@PathVariable String userDni) throws NotContentException {

		return new ResponseEntity<UserServiceModel>(userService.GetUsersBydni(userDni), HttpStatus.OK);
	}

	@GetMapping("/users/notEnabled")
	public ResponseEntity<Iterable<UserServiceModel>> GetNotEnabledUsers() throws NotContentException {

		return new ResponseEntity<Iterable<UserServiceModel>>(userService.getNotEnabledUsers(), HttpStatus.OK);
	}

	@GetMapping("/publicKey")
	public ResponseEntity<String> getPublicKey() throws NotContentException {

		return new ResponseEntity<String>(userService.getPublicKey(), HttpStatus.OK);
	}
	
	@GetMapping("/users/professor/student")
	public ResponseEntity<Iterable<UserServiceModel>> GetUsersWithoutAdminRole() throws NotContentException {

		return new ResponseEntity<Iterable<UserServiceModel>>(userService.findUsersWithoutAdminRole(), HttpStatus.OK);
	}


	@PostMapping("/users/login")
	public ResponseEntity<?> login(@RequestBody UserRequest request) {
		try {

			CifradoRSA ejemploRSA = new CifradoRSA();

			byte[] decoded = Base64.getDecoder().decode(request.getPassword());

			String passDescifrada = new String(ejemploRSA.descifrarTexto(decoded));

			Authentication authentication = userManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getDni(), passDescifrada));

			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			UserResponse response = new UserResponse(user.getDni(), accessToken, user.getRoles());

			return ResponseEntity.ok().body(response);

		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	


	@PostMapping("/users/signup")
	public ResponseEntity<?> signUp(@RequestBody UserRequest request) throws ConflictException, UserException {

		userService.signUp(request);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@PostMapping("/users/loginSinCifrado")
	public ResponseEntity<?> loginSinCifrado(@RequestBody UserRequest request) {
		try {

			Authentication authentication = userManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getDni(), request.getPassword()));

			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			UserResponse response = new UserResponse(user.getDni(), accessToken, user.getRoles());

			return ResponseEntity.ok().body(response);

		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	
	@PostMapping("/users/signupSinCifrado")
	public ResponseEntity<?> signUpSinCifrado(@RequestBody UserRequest request) throws ConflictException, UserException {

		userService.signUpSinCifrado(request);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/users/{userDni}")
	public ResponseEntity<Integer> deleteUser(@PathVariable String userDni) throws NotContentException {

		userService.deleteUser(userDni);

		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@PutMapping("/users/{userDni}/roles")
	public ResponseEntity<UserServiceModel> addRoles(@PathVariable String userDni, @RequestBody UserRequest request)
			throws ConflictException, UserException, NotContentException {

		return new ResponseEntity<UserServiceModel>(userService.addRoles(userDni, request), HttpStatus.OK);
	}

	@PutMapping("/users/{userDni}")
	public ResponseEntity<UserServiceModel> updateuser(@PathVariable String userDni, @RequestBody UserRequest request)
			throws ConflictException, UserException, NotContentException {

		return new ResponseEntity<UserServiceModel>(userService.updateUser(userDni, request), HttpStatus.OK);
	}
	
	
	@PutMapping("/users/admin/{userDni}")
	public ResponseEntity<UserServiceModel> updateuserAdmin(@PathVariable String userDni, @RequestBody UserRequest request)
			throws ConflictException, UserException, NotContentException {

		return new ResponseEntity<UserServiceModel>(userService.updateUserAdmin(userDni, request), HttpStatus.OK);
	}

}
