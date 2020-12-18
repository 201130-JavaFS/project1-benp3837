package com.revature.models;

public class LoginDTO { //DTO stands for data transfer objects. It is specifically for getting data from your front end
	
	//this is a MODEL of the data coming from the client
	
	//DTOs are traditionally public, since they should be easily accessible
	public String username;	
	public String password;
	
	
	//how do we get the user's other attributes from the database?
	
	//is this why I don't know how to send a user object back to JS
	
	
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public LoginDTO() {
		super();
	}
	
}
