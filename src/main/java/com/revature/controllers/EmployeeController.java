package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;

public class EmployeeController {

	private ReimbursementService rs = new ReimbursementService();
	private ObjectMapper om = new ObjectMapper();
	//private User u = new User();
	
	public void getPastReimbursements(HttpServletResponse res) throws IOException {
		List<Reimbursement> list = rs.getPastReimbursements();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
		
	public void getPendingReimbursements (HttpServletResponse res) throws IOException {
		List<Reimbursement> list = rs.getPendingReimbursements();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
}
