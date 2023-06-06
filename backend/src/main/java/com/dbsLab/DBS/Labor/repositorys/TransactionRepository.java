package com.dbsLab.DBS.Labor.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsLab.DBS.Labor.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}
