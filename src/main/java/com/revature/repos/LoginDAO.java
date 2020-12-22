package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class LoginDAO implements LoginDAOInterface{
	
	//gotta get username 
	public String getUsername(String username) { 
		
	try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
		
			String sql = "select user_username from ers_users where user_username = ?;"; //kind of funny but works
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); 

			rs = ps.executeQuery();

			if(rs.next()) {
			String result = rs.getString("user_username");
			return result;
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	//gotta get password
	public String getPassword(String password) { 
		
	try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
		
			String sql = "select user_password from ers_users where user_password = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password); 

			rs = ps.executeQuery();

			if(rs.next()) {
			String result = rs.getString("user_password");
			return result;
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	

}





/*
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String result = null;
		
			String sql = "select user_username from ers_users where user_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1); //1 hardcoded for now to debug

			result = ps.toString();
			//result = "Benp3837";
			
			return result;

			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	//gotta get password
	public String getPassword(User u) { 
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String result = null;
		
			String sql = "select user_password from ers_users where user_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);

			//result = ps.toString();
			result = "Password";	

			return result;

			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	//and then these methods get called in the login service to determine whether a user's login credentials are valid

}
	
	---------------------
	
	//gotta get username 
	public String getUsername(User u) { //SHOULD TAKE A USER U PARAMETER
		
	try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
		
			String sql = "select user_username from ers_users where user_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1); //is it because this doesn't retrieve the correct userId?
			//try hardcoding in a 1 (for Benp3837) and see if it works

			rs = ps.executeQuery();

			//String result = rs.getString("user_username");
			String result = "Benp3837";
			return result;

			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	//gotta get password
	public String getPassword(User u) { 
		
	try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
		
			String sql = "select user_password from ers_users where user_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1); //is it because this doesn't retrieve the correct userId?
			//try hardcoding in a 1 (for Benp3837) and see if it works

			rs = ps.executeQuery();

			//String result = rs.getString("user_password");
			String result = "Password";
			return result;
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	

}
	
	
*/