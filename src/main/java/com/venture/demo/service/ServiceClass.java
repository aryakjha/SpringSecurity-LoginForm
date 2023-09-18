package com.venture.demo.service;

import java.util.List;

import com.venture.demo.model.User;

public interface ServiceClass {
	boolean SaveUser(User user) ;
	
	List<User> findAllusers();
	
	boolean loginAuthentication(User user);
}
