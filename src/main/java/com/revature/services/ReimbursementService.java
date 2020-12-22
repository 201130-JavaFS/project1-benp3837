package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repos.ReimbursementDAOImpl;

public class ReimbursementService {
	private static final Logger log = LogManager.getLogger(LoginService.class);
	
	ReimbursementDAOImpl rd = new ReimbursementDAOImpl();
	
	public void addNewTicket(int typeId, String description, double amount) {
		if(typeId > 0 && typeId < 5) {
			rd.addReimbursement(typeId, description, amount);
			log.info("Ticket submitted for $" + amount + "0");
		} else {System.out.println("failed");}
	}
	
	public List<Reimbursement> getPastReimbursements() {
		log.info("Past reimbursements requested");
		return rd.viewPastTickets();
	}

	public List<Reimbursement> getPendingReimbursements() {
		log.info("Pending reimbursements requested");
		return rd.viewPendingTickets();
	}

	//manager methods start here------------------
	
	public List<Reimbursement> viewAllTickets() {
		log.info("All reimbursements requested");
		return rd.viewAllTickets();
	}
	
	public List<Reimbursement> filterByStatus(int statusId) {
	
		if(statusId > 0 && statusId < 4) { //check that the input is valid
			log.info("reimbursements with status " + statusId + " requested");
			return rd.filterByStatus(statusId);
		} else {return null;}
	}
	
	public void resolveTicket(int reimbursementId, int statusId) {
		if(statusId > 0 && statusId < 4) {
			rd.resolveTicket(reimbursementId, statusId);
			log.info("Reimbursement " + reimbursementId + " requested");
		} else {}
	}
	
}
