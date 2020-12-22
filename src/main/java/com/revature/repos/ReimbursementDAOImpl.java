package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	
	@Override
	public void addReimbursement(int typeId, String description, double amount) {
		// insert into reimbursements (everything except reimb id) values (everything except reimb id. status pending. resolver & resolved = null);
		try (Connection conn = ConnectionUtil.getConnection()){
		
			String sql = "insert into ers_reimbursements "
						  + "(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, "
						  + "reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
						  + "values (?, current_timestamp, null, ?, 1, 2, 1, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, description);
			ps.setInt(3, typeId);

			ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Reimbursement> viewPendingTickets() {
	// select * from reimbursements where userId = this userId and status = "pending";
	//when an employee creates a new ticket, they are the author. the resolver & resolved is null 
																//until the manager approves/rejects, and their ID/timestamp is the resolver/resolved
		try (Connection conn = ConnectionUtil.getConnection()){
				
				ResultSet rs = null;
			
				String sql = "select * from ers_reimbursements where reimb_status_id = 1;";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				//ps.setInt(1, u.getUserId());

				rs = ps.executeQuery();
				
				List<Reimbursement> list = new ArrayList<>();
	
				while(rs.next()) {
					Reimbursement r = new Reimbursement (
							rs.getInt("reimb_id"), 
							rs.getDouble("reimb_amount"),
							rs.getString("reimb_submitted"),
							rs.getString("reimb_resolved"),
							rs.getString("reimb_description"),
							rs.getInt("reimb_author"),
							rs.getInt("reimb_resolver"),
							rs.getInt("reimb_status_id"),
							rs.getInt("reimb_type_id")								
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
	public List<Reimbursement> viewPastTickets() {
		// select * from reimbursements where userID = this userId and status != pending; 
		try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from ers_reimbursements where reimb_status_id != 1;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, u.getUserId());

			rs = ps.executeQuery();
			
			List<Reimbursement> list = new ArrayList<>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement (
						rs.getInt("reimb_id"), 
						rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")								
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
		try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from ers_reimbursements;";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			
			List<Reimbursement> list = new ArrayList<>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement (
						rs.getInt("reimb_id"), 
						rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")								
						);
						
				list.add(r); //now the list will be populated by all tickets
			}
			
			return list;
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> filterByStatus(int statusId) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from ers_reimbursements where reimb_status_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, statusId);
			
			rs = ps.executeQuery();
			
			List<Reimbursement> list = new ArrayList<>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement (
						rs.getInt("reimb_id"), 
						rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")								
						);
						
				list.add(r); //now the list will be populated by all the selected tickets
			}
			
			return list;
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void resolveTicket(int reimbursementId, int statusId) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update ers_reimbursements set reimb_status_id = ?, reimb_resolver = 2, reimb_resolved = current_timestamp "
					+ "where reimb_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, statusId);
			ps.setInt(2, reimbursementId);
			ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	/*
	@Override
	public void rejectTicket(int reimbursementId) { //will probably just make one resolveTicket method

		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update ers_reimbursements set reimb_status_id = 3, reimb_resolver = 2, reimb_resolved = current_timestamp "
					+ "where reimbursementID = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimbursementId);
			ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	*/
}
