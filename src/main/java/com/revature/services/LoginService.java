package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.repos.LoginDAO;

public class LoginService { 
	private static final Logger log = LogManager.getLogger(LoginService.class);

	LoginDAO lDAO = new LoginDAO();
	
	public boolean login(String username, String password) {
		if(username.equals(lDAO.getUsername(username)) && password.equals(lDAO.getPassword(password))) { 
			log.info("User " + username + " logged in.");
			return true;
			
		}
		return false; //if the username/password combo doesn't pass the vibe check
	}
	
}
