package com.simplilearn.fswd.foodbox.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.simplilearn.fswd.foodbox.backend.model.Admin;
import com.simplilearn.fswd.foodbox.backend.model.Login;
import com.simplilearn.fswd.foodbox.backend.model.Message;
import com.simplilearn.fswd.foodbox.backend.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController{
	
	@Autowired
	AdminService service;

	@PostMapping("/admin")
	public ResponseEntity<?> createAdmin(@RequestBody Admin user) {
		
		service.createUser(user);
		
		return new ResponseEntity<> (
				new Message(
						HttpStatus.OK,
						"User Created",
						new Gson().toJson(user)
						),
				HttpStatus.OK
				);		
	}
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<?> updateAdmin(@RequestBody Admin user) {
		
		service.updateUser(user);
		
		return new ResponseEntity<> (
				new Message(
						HttpStatus.OK,
						"User Updated",
						new Gson().toJson(user)
						),
				HttpStatus.OK
				);		
	}
	
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		
		Admin user = new Admin();
		user.setId(id);
		service.deleteUser(user);
		
		return new ResponseEntity<> (
				new Message(
						HttpStatus.OK,
						"User Deleted",
						new Gson().toJson(user)
						),
				HttpStatus.OK
				);			
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id) {
		
		Admin user = new Admin();
		user.setId(id);
		user = service.getUser(user);
		
		return new ResponseEntity<> (
				new Message(
						HttpStatus.OK,
						"User Fetched",
						new Gson().toJson(user)
						),
				HttpStatus.OK
				);			
	}
	
	@GetMapping("/admin/username/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
		
		Admin user = service.findByUsername(username).get(0);
		
		return new ResponseEntity<> (
				new Message(
						HttpStatus.OK,
						"User Fetched",
						new Gson().toJson(user)
						),
				HttpStatus.OK
				);			
	}
	
	@GetMapping("/admin/login/{username}")
	public ResponseEntity<?> getUserByUsernameAndPassword(@RequestBody Login login) {
		
		Admin user = service.findByUsernameAndPassword(login.getUsername(), login.getPassword()).get(0);
		
		return new ResponseEntity<> (
				new Message(
						HttpStatus.OK,
						"User Fetched",
						new Gson().toJson(user)
						),
				HttpStatus.OK
				);			
	}

}
