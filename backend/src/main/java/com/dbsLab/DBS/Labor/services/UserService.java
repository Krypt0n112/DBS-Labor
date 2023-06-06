package com.dbsLab.DBS.Labor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbsLab.DBS.Labor.models.User;
import com.dbsLab.DBS.Labor.repositorys.UserRepository;

@Service
@Transactional
public class UserService {

	private UserRepository repo;
	
	@Autowired
	private void setRepo(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> getAll(){
		return repo.findAll();
	}
	
	public User get(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public User save(User user) {
		return repo.save(user);
	}
	
	public void delete(User user) {
		repo.delete(user);
	}
}
