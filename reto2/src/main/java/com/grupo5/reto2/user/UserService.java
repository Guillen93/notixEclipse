package com.grupo5.reto2.user;

import com.grupo5.reto2.exceptions.NotContentException;

public interface UserService {
	User signUp(User user) throws UserException;
	Iterable<UserServiceModel> GetUsers() throws NotContentException;

	UserServiceModel GetUsersBydni(String username) throws NotContentException;
	
}
