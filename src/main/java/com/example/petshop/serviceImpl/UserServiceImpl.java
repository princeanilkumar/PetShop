package com.example.petshop.serviceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.petshop.controller.UserController;
import com.example.petshop.dao.UserDao;
import com.example.petshop.exceptions.InvalidCredentialsException;
import com.example.petshop.models.User;
import com.example.petshop.service.UserService;


/**
 * @author anilkumar
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private static Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
	UserDao userDao;
	
	
	/**
	 * {@inheritDoc}
	 * @throws InvalidCredentialsException 
	 */
	@Override
	public boolean authenticateUser(String userName, String password) throws InvalidCredentialsException {
		logger.info("implementaion of authenticating the user");
		User user = userDao.findByUserNameAndPassword(userName,password);
		if (user!=null)
			return true;
		throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials"); 
		}

	}

	

