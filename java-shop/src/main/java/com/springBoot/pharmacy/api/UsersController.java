package com.springBoot.pharmacy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.pharmacy.business.abstracts.UserService;
import com.springBoot.pharmacy.entities.User;
import com.springBoot.pharmacy.entities.dtos.UserLoginDto;
import com.springBoot.pharmacy.entities.dtos.UserSignUpDto;

import core.utilities.results.ErrorResult;
import core.utilities.results.Result;
import core.utilities.results.SuccessResult;
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	


	
	
	@PostMapping("/addUser")
	public ResponseEntity<Result> addUser(@RequestBody UserSignUpDto userSignUpDto) {
	    User user = new User();
	    user.setEmail(userSignUpDto.getEmail());
	    user.setPassword(userSignUpDto.getPassword());
	    return ResponseEntity.ok(this.userService.addUser(user));
	}

	
	
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<Result> login(@RequestBody UserLoginDto userLoginDto) {
	    boolean success = this.userService.verifyUser(userLoginDto.getEmail(), userLoginDto.getPassword());
	    if (success) {
	        return ResponseEntity.ok(new SuccessResult("Login successful"));
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResult("Invalid credentials"));
	    }
	}

	
	
	
}
