package com.revature.repos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDAO {

	//employee stuff
	
	public void addReimbursement(Reimbursement r);
	
	public List<Reimbursement> viewPendingTickets();
	
	public List<Reimbursement> viewPastTickets();
	

	//manager stuff
	
	public List<Reimbursement> viewAllTickets();
	
	public List<Reimbursement> filterByStatus(int statusId);
	
	public void approveTicket();
	
	public void rejectTicket();
	
}
