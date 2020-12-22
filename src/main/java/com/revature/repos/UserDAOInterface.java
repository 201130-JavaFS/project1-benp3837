package com.revature.repos;

import com.revature.models.User;

public interface UserDAOInterface {

	public User getUserByUsername(String username);
	
}
