package com.revature.repos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDAO {

	//employee stuff
	
	public void addReimbursement(Reimbursement r);
	
	public List<Reimbursement> viewPendingTickets(User u);
	
	public List<Reimbursement> viewPastTickets(User u);
	

	//manager stuff
	
	public List<Reimbursement> viewAllTickets();
	
	public List<Reimbursement> filterByStatus(String status);
	
	public void changeStatus();
	
}
