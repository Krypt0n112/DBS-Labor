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

import com.dbsLab.DBS.Labor.models.*;
import com.dbsLab.DBS.Labor.services.*;

@Service
@RestController
public class RestApi {
	private UserService userService;
	private AccountService accountService;
	private TransactionService transactionService;
	
	@Autowired
	public void setUserService(UserService service) {
		this.userService = service;
	}
	
	@Autowired
	public void setAccountService(AccountService service) {
		this.accountService = service;
	}
	
	@Autowired
	public void setTransactionService(TransactionService service) {
		this.transactionService = service;
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
	
	@GetMapping("/account/all")
	public ResponseEntity<List<Account>> getAllAccounts(){
		return ResponseEntity.ok(accountService.getAll());
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable Long id){
		try {
			Account acc = accountService.get(id);
			return ResponseEntity.ok(acc);
		}catch(NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/account/add")
	public ResponseEntity<Account> setAccount(@RequestBody Account acc) {
		return ResponseEntity.ok(accountService.save(acc));
	}
	
	@PutMapping("/account/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account acc){
		try {
			Account check = accountService.get(acc.getId());
			return ResponseEntity.ok(accountService.save(acc));
		}catch(NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/account/delete")
	public String deleteAccount(@RequestBody Account acc) {
		try {
			accountService.delete(acc);
			return "Account succesfull deleted";
		}catch(Exception e) {
			return "Failed to delete";
		}
	}
	
	//Transaction section
	//----------------
	
	@GetMapping("/transaction/all")
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		return ResponseEntity.ok(transactionService.getAll());
	}
	
	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable Long id){
		try {
			Transaction trans = transactionService.get(id);
			return ResponseEntity.ok(trans);
		}catch(NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/transaction/add")
	public ResponseEntity<Transaction> setTransaction(@RequestBody Transaction trans){
		return ResponseEntity.ok(transactionService.save(trans));
	}
	
	@PutMapping("/transaction/update")
	public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction trans){
		try {
			Transaction check = transactionService.get(trans.getId());
			return ResponseEntity.ok(transactionService.save(trans));
		}catch(NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/transaction/delete")
	public String deleteTransaction(@RequestBody Transaction trans) {
		try {
			transactionService.delete(trans);
			return "Transaction Succesfull deleted";
		}catch(Exception e) {
			return "Transaction not deleted";
		}
	}
	
}
