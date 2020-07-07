package com.example.petshop.service;

import com.example.petshop.exceptions.InvalidCredentialsException;

/**
 * @author anilkumar
 *
 */
public interface UserService {

	
	/**
	 * This method is used to authenticate User
	 * @param loginDto
	 * @return boolean true if an authenticated User else false
	 * @throws InvalidCredentialsException 
	 */
	public boolean authenticateUser(String userName, String password) throws InvalidCredentialsException;
}
