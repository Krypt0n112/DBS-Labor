package com.dbsLab.DBS.Labor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
