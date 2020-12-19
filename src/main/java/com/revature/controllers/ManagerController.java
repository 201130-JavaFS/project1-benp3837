package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
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
	
	public void getTicketsByStatus(HttpServletRequest req, HttpServletResponse res) throws IOException {

		if(req.getMethod().equals("POST")) { //make sure we're reading a POST request
			BufferedReader reader = req.getReader(); //BufferedReader is how we read each line of our body
			
			StringBuilder sb = new StringBuilder(); //will get filled with the values of the JSON object
			
			String line = reader.readLine();
			
			while(line!=null) { //while there are still lines...
				sb.append(line); //add the line 
				line = reader.readLine(); //move on to the next line
			}
			
			//all of this stuff above gets the json string, and we put it into the body variable below
			
			String body = new String(sb); 
			
			ReimbursementDTO rDTO = om.readValue(body, ReimbursementDTO.class); 
			//using object mapper, this reads the JSON string & make it into a DTO object			
			
			List<Reimbursement> list = rs.filterByStatus(rDTO.statusId); //get the filtered reimbursements
			String json = om.writeValueAsString(list); //put the list into a String
			res.getWriter().print(json); //send her back as json
			res.setStatus(200); //200 Success
		}
	}	
	public void resolveTicket(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
	}
	
}
