package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repos.ReimbursementDAOImpl;

public class ReimbursementService {

	ReimbursementDAOImpl rd = new ReimbursementDAOImpl();
	
	public void addNewTicket(int typeId, String description, double amount) {
		rd.addReimbursement(typeId, description, amount);
	}
	
	public List<Reimbursement> getPastReimbursements() {
		return rd.viewPastTickets();
	
	}

	public List<Reimbursement> getPendingReimbursements() {
		return rd.viewPendingTickets();
	}

	//manager methods start here------------------
	
	public List<Reimbursement> viewAllTickets() {
		return rd.viewAllTickets();
	}
	
	public List<Reimbursement> filterByStatus(int statusId) {
		return rd.filterByStatus(statusId);
	}
	
	public void resolveTicket(int reimbursementId, int statusId) {
		rd.resolveTicket(reimbursementId, statusId);
	}
	
}
