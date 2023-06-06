package com.dbsLab.DBS.Labor;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbsLab.DBS.Labor.models.User;
import com.dbsLab.DBS.Labor.services.UserService;

@Service
@RestController
public class RestApi {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService service) {
		this.userService = service;
	}
	
	@RequestMapping("/")
	public String start() {
		return "Backend is running";
	}
	
	//User section
	//----------------
	
	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.getAll());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		try {
			User user = userService.get(id);
			return ResponseEntity.ok(user);
		}catch(NoSuchElementException e){
			return ResponseEntity.notFound().build();
		}
	}
	
	//Create user, body dont need id
	@PostMapping("/user/add")
	public User setUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	//Update user, body needs id (without it creates a new user)
	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user) {
		try {
			User check = userService.get((long) user.getId());
			
			return userService.save(user);
		}catch(Exception e){
			return null;
		}
	}
	
	@DeleteMapping("/user/delete")
	public String deleteUser(@RequestBody User user) {
		try {
			userService.delete(user);
			return "User successfully deleted";
		}catch(Exception e) {
			return "Failure when deleting user";
		}
	}
	
	//account section
	//----------------
	
	
}
