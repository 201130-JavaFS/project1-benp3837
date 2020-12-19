package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
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
	
	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) { //make sure we're reading a POST request
			BufferedReader reader = req.getReader(); //BufferedReader is how we read each line of our body
			
			StringBuilder sb = new StringBuilder(); //will get filled with the values of the JSON object
			
			String line = reader.readLine();
			
			while(line!=null) { //while there are still lines...
				sb.append(line); //add the line 
				line = reader.readLine(); //move on to the next line
			}
			
			String body = new String(sb); //request body goes into this variable
			
			ReimbursementDTO rDTO = om.readValue(body, ReimbursementDTO.class);	//make a ReimbursementDTO with the body
			rs.addNewTicket(rDTO.typeId, rDTO.description, rDTO.amount);		
			res.setStatus(200);
			
		}
	}
	
}
