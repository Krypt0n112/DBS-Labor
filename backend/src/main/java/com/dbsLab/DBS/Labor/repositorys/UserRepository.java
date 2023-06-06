package com.dbsLab.DBS.Labor.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsLab.DBS.Labor.models.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
