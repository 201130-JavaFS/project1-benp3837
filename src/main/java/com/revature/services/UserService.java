package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserDAO;

public class UserService {

	UserDAO uDao = new UserDAO();
	
	public User getUser(String username) {
		return uDao.getUserByUsername(username);
	}
}
