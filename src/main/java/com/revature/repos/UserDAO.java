package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAO implements UserDAOInterface {

	public User getUserByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
		
			String sql = "select * from ers_users where user_username = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				User u = new User (
						rs.getInt("user_id"),
						rs.getString("user_username"),
						rs.getString("user_password"),
						rs.getString("user_firstname"),
						rs.getString("user_lastname"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);
				
				return u;
			}
					
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
