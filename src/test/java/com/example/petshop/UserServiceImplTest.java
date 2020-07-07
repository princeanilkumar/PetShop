package com.example.petshop;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.petshop.dao.UserDao;
import com.example.petshop.exceptions.InvalidCredentialsException;
import com.example.petshop.models.User;
import com.example.petshop.serviceImpl.UserServiceImpl;



@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
    User user;
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	
	
	

	@Test
	public void authenticateTest1() throws InvalidCredentialsException {
		//given
		User user=new User();
		user.setUserName("anilkumar");
		user.setPassword("1234");
		
		
		when(userDao.findByUserNameAndPassword("anilkumar","1234")).thenReturn(user);
				
		
		//when
		Boolean isExists = userServiceImpl.authenticateUser("anilkumar", "1234");
		
		//then
		verify(userDao).findByUserNameAndPassword("anilkumar","1234");
		assertTrue(isExists);
	}
	
	@Test
	public void authenticateTest2() {
		//given
		User user = new User();
		user.setUserName("anilkumar");
		user.setPassword("1234");	
		
		when(userDao.findByUserNameAndPassword("anilkumar","1234")).thenReturn(null);
		
		//when
		
		//then
		assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.authenticateUser("anilkumar", "1234"));
	}
	
	

}
