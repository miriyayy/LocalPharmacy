package com.springBoot.pharmacy.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.pharmacy.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User getByEmail(String email);
	User findByPassword(String email);


}
