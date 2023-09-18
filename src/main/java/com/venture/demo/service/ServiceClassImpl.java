package com.venture.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.venture.demo.dao.UserRepository;
import com.venture.demo.model.User;

@Service
public class ServiceClassImpl implements ServiceClass {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 

	@Override
	public boolean SaveUser(User user) {
		// TODO Auto-generated method stub
		try {
//			User u = new User();
			String pass = user.getPassword();
			
			user.setPassword(passwordEncoder.encode(pass));
			User u = userRepository.save(user);
			
			if(u != null) {
			return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return false;
		
	}

	@Override
	public List<User> findAllusers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public boolean loginAuthentication(User user) {
		// TODO Auto-generated method stub
		User u = userRepository.findByEmail(user.getEmail());
		if(u != null) {
			if(passwordEncoder.matches(user.getPassword(), u.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
