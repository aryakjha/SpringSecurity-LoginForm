package com.venture.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venture.demo.model.User;
import com.venture.demo.service.ServiceClass;

@RestController
@CrossOrigin
public class AppRestController {
		
	@Autowired
	private ServiceClass serviceClass;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUserDetails(@RequestBody User user){
		if(serviceClass.SaveUser(user) == false) {
			return new ResponseEntity<>("Data Not Saved !! " , HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		else {
			return new ResponseEntity<>("Data Saved" , HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(serviceClass.findAllusers(),HttpStatus.OK);
	}
	
	@PostMapping("/loginurl")
	public ResponseEntity<String> loginAuthentication(@RequestBody User user){
		if(serviceClass.loginAuthentication(user)) {
			return new ResponseEntity<>("Login Successful!!" , HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Login Unsuccessful !! " , HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/login_page")
	public String loginPage() {
		return "login";
	}
}























