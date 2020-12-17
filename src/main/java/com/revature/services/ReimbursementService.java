package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repos.ReimbursementDAOImpl;

public class ReimbursementService {

	ReimbursementDAOImpl rd = new ReimbursementDAOImpl();
	
	public List<Reimbursement> getPastReimbursements(User u) {
		// TODO Auto-generated method stub
		rd.viewPastTickets(u);
		return null;
	}

	public List<Reimbursement> getPendingReimbursements(User u) {
		// TODO Auto-generated method stub
		rd.viewPendingTickets(u);
		return null;
	}

	
	
}
