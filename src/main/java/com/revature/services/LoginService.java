package com.revature.services;

import com.revature.models.User;
import com.revature.repos.LoginDAO;

public class LoginService { 


	LoginDAO lDAO = new LoginDAO();
	User u = new User(); //This could be the problem, the DAO isn't being sent the correct userId, because the current user isn't selected?
						 //It's either this, or my DAO methods aren't acting right
	
	public boolean login(String username, String password) {
		if(username.equals(lDAO.getUsername(username)) && password.equals(lDAO.getPassword(password))) { //hardcoding still gets 404. so it's a connection error?
			return true;
		}
		return false; //if the username/password combo doesn't pass the vibe check
	}
	
}
