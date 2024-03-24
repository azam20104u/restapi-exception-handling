package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDAO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserResource;

@RestController
public class UserController {

	@Autowired
	private UserDAO dao;
	
	@PostMapping("/")
	public ResponseEntity<UserResource> createUser(@RequestBody UserResource user){
		return ResponseEntity.ok(dao.createUser(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResource> getUser(@PathVariable("id") Integer id){
		UserResource resource = dao.findUserById(id);
		if(resource == null) {
			throw new UserNotFoundException(id + " id not found");
		}
		return ResponseEntity.ok(resource);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserResource>> getAllUsers(){
		return ResponseEntity.ok(dao.getAllUsers());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserResource> createUser(@PathVariable("id") Integer id, @RequestBody UserResource user){
		UserResource resource = dao.updateUser(id,user);
		if(resource == null) {
			throw new UserNotFoundException(id + " id not found");
		}
		return ResponseEntity.ok(resource);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserResource> deleteUser(@PathVariable("id") Integer id){
		UserResource resource = dao.deleteUser(id);
		if(resource == null) {
			throw new UserNotFoundException(id + " id not found");
		}
		return ResponseEntity.ok(resource);
	}
}
