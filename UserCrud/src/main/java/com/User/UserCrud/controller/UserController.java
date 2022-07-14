package com.User.UserCrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.User.UserCrud.exception.ResourceNotFoundException;
import com.User.UserCrud.model.User;
import com.User.UserCrud.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	//Create user
	
	@PostMapping("/user")
	public User createUser(@RequestBody @Valid User user) {
		
		return userRepository.save(user);
		
	}
	
	//Get user by id
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") long userId) throws ResourceNotFoundException {
		
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found for this::"+userId));
		return  ResponseEntity.ok().body(user);
	}
	
	//Update user
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") long userId, @RequestBody User userDetails) throws ResourceNotFoundException {
		
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found for this::"+userId));

		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setDob(userDetails.getDob());
		user.setEmailId(userDetails.getEmailId());
		return ResponseEntity.ok().body(user);
	}
	
	//Delete user
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long userId) throws ResourceNotFoundException {
		
		userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found for this::"+userId));
		
		
		userRepository.deleteById(userId);
		return ResponseEntity.ok().build();
		
	}
	  
}
