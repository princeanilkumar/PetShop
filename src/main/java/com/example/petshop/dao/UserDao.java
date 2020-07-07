package com.example.petshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.petshop.models.User;

/**
 * @author anilkumar
 *
 */
public interface UserDao extends CrudRepository<User, Integer>{

	/**
	 * @param userName
	 * @param password
	 * @return user
	 */
	User findByUserNameAndPassword(String userName, String password);
	

}
