package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	
	@Override
	public void addReimbursement(Reimbursement r) {
		// insert into reimbursements (everything except reimb id) values (everything except reimb id. status pending);
		
	}
	
	@Override
	public List<Reimbursement> viewPendingTickets(User u) {
	// select * from reimbursements where userId = this userId and status = "pending";
	//when an employee creates a new ticket, they are the author. the resolver & resolved is null 
																//until the manager approves/rejects, and their ID/timestamp is the resolver/resolved
		try (Connection conn = ConnectionUtil.getConnection()){
				
				ResultSet rs = null;
			
				String sql = "select * from ers_reimbursements where reimb_status_id = 1 and reimb_author = ?;";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, u.getUserId());

				rs = ps.executeQuery();
				
				List<Reimbursement> list = new ArrayList<>();
	
				while(rs.next()) {
					Reimbursement r = new Reimbursement (
							/*result.getInt("ave_id"), 
							result.getString("ave_name"),
							result.getString("ave_power"),
							result.getString("first_name"),
							result.getString("last_name"),
							result.getInt("power_level"),
							null	//home_fk could be null, but if not it takes a Home object	
							*/	
							);
							
					list.add(r); //now the list will be populated by all the user's pending tickets
				}
				
				return list;
				
			} catch (SQLException e){
				e.printStackTrace();
			}
			return null;
		}
	
	@Override
	public List<Reimbursement> viewPastTickets(User u) {
		// select * from reimbursements where userID = this userId and status != pending; 
		try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from ers_reimbursements where reimb_status_id != 1 and reimb_author = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());

			rs = ps.executeQuery();
			
			List<Reimbursement> list = new ArrayList<>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement (
						/*result.getInt("ave_id"), 
						result.getString("ave_name"),
						result.getString("ave_power"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getInt("power_level"),
						null	//home_fk could be null, but if not it takes a Home object	
						*/	
						);
						
				list.add(r); //now the list will be populated by all the user's past tickets
			}
			
			return list;
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
 
	
	//manager methods start here--------------

	
	@Override
	public List<Reimbursement> viewAllTickets() {
		// select * from reimbursements;
		return null;
	}

	@Override
	public List<Reimbursement> filterByStatus(String status) {
		//select * from reimbursements where reimb_status = ?
		return null;
	}

	@Override
	public void changeStatus() {
		//update statement probably idk lol
		//
		
	}

}
