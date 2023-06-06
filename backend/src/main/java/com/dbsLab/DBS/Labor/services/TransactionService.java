package com.dbsLab.DBS.Labor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbsLab.DBS.Labor.models.Transaction;
import com.dbsLab.DBS.Labor.repositorys.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	private TransactionRepository repo;
	
	@Autowired
	public void setRepo(TransactionRepository repo) {
		this.repo = repo;
	}
	
	public List<Transaction> getAll(){
		return repo.findAll();
	}
	
	public Transaction get(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public Transaction save(Transaction trans) {
		return repo.save(trans);
	}
	
	public void delete(Transaction trans) {
		repo.delete(trans);
	}
}
