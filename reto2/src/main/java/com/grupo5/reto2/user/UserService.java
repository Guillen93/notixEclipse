package com.grupo5.reto2.user;

import com.grupo5.reto2.exceptions.ConflictException;
import com.grupo5.reto2.exceptions.NotContentException;

public interface UserService {
	User signUp(UserRequest request) throws UserException, ConflictException;
	Iterable<UserServiceModel> GetUsers() throws NotContentException;

	Iterable<UserServiceModel> getNotEnabledUsers() throws NotContentException;
	
	UserServiceModel GetUsersBydni(String username) throws NotContentException;
	UserServiceModel updateUser(String username,UserRequest request) throws NotContentException;
	
	Boolean deleteUser(String username) throws NotContentException;
	UserServiceModel addRoles(String userDni, UserRequest request) throws NotContentException;
}
