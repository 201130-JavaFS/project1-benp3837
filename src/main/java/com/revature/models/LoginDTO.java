package com.revature.models;

public class LoginDTO { //DTO stands for data transfer objects. It is specifically for getting data from your front end
	
	//DTOs are traditionally public, since they should be easily accessible
	public String username;	
	public String password;
	
	
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public LoginDTO() {
		super();
	}
	
}
