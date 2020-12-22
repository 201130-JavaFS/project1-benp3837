package com.revature.repos;

import java.util.List;

import com.revature.models.Reimbursement;


public interface ReimbursementDAO {

	//employee stuff
	
	public void addReimbursement(int typeId, String description, double amount);
	
	public List<Reimbursement> viewPendingTickets();
	
	public List<Reimbursement> viewPastTickets();
	

	//manager stuff
	
	public List<Reimbursement> viewAllTickets();
	
	public List<Reimbursement> filterByStatus(int statusId);
	
	public void resolveTicket(int reimbursementId, int reimbursementStatus);
	
	//public void rejectTicket(int reimbursementId);
	
}
