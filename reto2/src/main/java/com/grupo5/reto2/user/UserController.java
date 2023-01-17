package com.grupo5.reto2.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;
import com.grupo5.reto2.security.JwtTokenUtil;

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
		
		return new ResponseEntity <Iterable<UserServiceModel>>(userService.GetUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{userDni}")
	public ResponseEntity<UserServiceModel> GetUserbyDni(@PathVariable String userDni) throws NotContentException {
		
		return new ResponseEntity <UserServiceModel>(userService.GetUsersBydni(userDni), HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/users/login")
	public ResponseEntity<?> login(@RequestBody UserRequest request) {
		try {
			Authentication authentication = userManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getDni(), request.getPassword())
					);
			
			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			UserResponse response = new UserResponse(user.getDni(), accessToken);
			
			return ResponseEntity.ok().body(response);
		
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping("/users/signup")
	public ResponseEntity<?> signIn(@RequestBody UserRequest request) throws ConflictException, UserException {
		User user = new User (request.getDni(), request.getPassword());

			userService.signUp(user);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/{userDni}")
	public ResponseEntity<Integer> deleteUser(@PathVariable String userDni) throws NotContentException {

		userService.deleteUser(userDni);

		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	

	
}
