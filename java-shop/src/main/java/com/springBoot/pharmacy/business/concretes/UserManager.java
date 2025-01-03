package com.springBoot.pharmacy.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.pharmacy.business.abstracts.UserService;
import com.springBoot.pharmacy.dataAccess.UserDao;
import com.springBoot.pharmacy.entities.User;


import core.utilities.results.Result;
import core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public Result addUser(User user) {
		this.userDao.save(user);
		return new SuccessResult("user added successfully");
	}



	@Override
	public boolean verifyUser(String email,String password) {
		 User user = this.userDao.getByEmail(email);
		    if (user != null && user.getPassword().equals(password)) {
		        return true;
		    }
		    return false;
		
	}
	
	
	
	

}
