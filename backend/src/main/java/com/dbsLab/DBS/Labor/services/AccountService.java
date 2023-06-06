package com.dbsLab.DBS.Labor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbsLab.DBS.Labor.models.Account;
import com.dbsLab.DBS.Labor.repositorys.AccountRepository;

@Service
@Transactional
public class AccountService {

	private AccountRepository repo;
	
	@Autowired
	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
	
	public List<Account> getAll(){
		return repo.findAll();
	}
	
	public Account get(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public Account save(Account account) {
		return repo.save(account);
	}
	
	public void delete(Account account) {
		repo.delete(account);
	}
}
