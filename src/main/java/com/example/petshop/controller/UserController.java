package com.example.petshop.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.dtos.LoginDto;
import com.example.petshop.dtos.StatusRequestDto;
import com.example.petshop.exceptions.InvalidCredentialsException;
import com.example.petshop.service.UserService;


/**
 * @author anilkumar
 *
 */
@RestController
public class UserController {

	private static Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	UserService userService;

	
	/**
	 * This method is used to authenticate the user
	 * 
	 * @param loginDto
	 * @return String
	 * @throws InvalidCredentialsException
	 */
	@PostMapping("/users/login")
	public String authenticateUser(@RequestBody LoginDto loginDto) throws InvalidCredentialsException {
		logger.info("authenticating the user");
		boolean isExists;
		isExists = userService.authenticateUser(loginDto.getUserName(), loginDto.getPassword());
		if (isExists)
			return "logged in successfully";
		else {
			return "Credentials are incorrect";
		}
	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<StatusRequestDto> exceptionHandler(InvalidCredentialsException exception){
		 StatusRequestDto errorresponse=new StatusRequestDto();
	        errorresponse.setStatusCode(500);
	        errorresponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorresponse,HttpStatus.NOT_FOUND);
	}
}