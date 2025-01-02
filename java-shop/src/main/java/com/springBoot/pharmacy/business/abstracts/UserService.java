package com.springBoot.pharmacy.business.abstracts;

import com.springBoot.pharmacy.entities.User;
import com.springBoot.pharmacy.entities.dtos.UserLoginDto;

import core.utilities.results.Result;

public interface UserService {
	Result addUser(User user);
	boolean verifyUser(String email,String password);
	

}
