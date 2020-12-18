package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class ManagerController {

	private ReimbursementService rs = new ReimbursementService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getAllTickets(HttpServletResponse res) throws IOException {
		List<Reimbursement> list = rs.viewAllTickets();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
}
