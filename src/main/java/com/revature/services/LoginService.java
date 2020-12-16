package com.revature.services;

public class LoginService { 
	
	//for the demo, we're using hardcoded username and password
	//you will ACTUALLY have to send a json string with a username and password, parse it, and compare it to the ones in the DB
	//and then like below, the method will return a boolean indicating valid or invalid username/password

	public boolean login(String username, String password) {
		if(username.equals("agent") && password.equals("cellist")) {
			//this will actually be if(username.equals(dao get username) && password.equals(dao get password)){}
			return true;
		}
		return false; //if the username/password combo doesn't pass the vibe check
	}
	
}
