//package com.grupo5.reto2.user;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.grupo5.reto2.role.Rol;
//import com.grupo5.reto2.role.Role;
//import com.grupo5.reto2.role.RoleRepository;
//
//@Service("userDetailsService")
//public class UserServiceImpl implements UserService, UserDetailsService {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByDni(username)
//                .orElseThrow(
//                        () -> new UsernameNotFoundException("User " + username + " not found"));
//	}
//	
//	@Override
//	public User signUp(User user) throws UserException {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String password = passwordEncoder.encode(user.getPassword());
//		user.setPassword(password);
//
//		Role userRole = roleRepository.findByRole(Rol.Student.name()).get();
//		Set<Role> roles = new HashSet<Role>();
//		roles.add(userRole);
//		
//		user.setEnabled(true);
//		user.setRoles(roles);
//		
//		try {
//			return userRepository.save(user);
//		} catch (DataAccessException e) {
//			throw new UserException(e.getMessage());
//		}
//		
//	}
//
//}
