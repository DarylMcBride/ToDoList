package com.qa.boot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.boot.model.Users;

public interface UserRepository extends JpaRepository<Users , Integer> {

	
	Users findByUsername(String username);

}
