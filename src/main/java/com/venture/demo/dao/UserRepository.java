package com.venture.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venture.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
