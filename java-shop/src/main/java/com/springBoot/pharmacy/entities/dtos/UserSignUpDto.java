package com.springBoot.pharmacy.entities.dtos;

public class UserSignUpDto {

	private String email;
	private String password;
	public UserSignUpDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public UserSignUpDto() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
