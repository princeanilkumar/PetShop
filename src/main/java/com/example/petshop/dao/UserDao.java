package com.example.petshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.petshop.models.User;

public interface UserDao extends CrudRepository<User, Integer>{

	User findByUserNameAndPassword(String userName, String password);
	

}
