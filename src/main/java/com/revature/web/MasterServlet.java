package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;

public class MasterServlet extends HttpServlet{
	
	private EmployeeController ec = new EmployeeController();
	private LoginController lc = new LoginController();
	private ManagerController mc = new ManagerController();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json"); //its JSON the servlet is sending back ;)
		
		res.setStatus(404); //if no cases in the switch statement handle it, we default to 404
		
		final String URI = req.getRequestURI().replace("/project-1/", "");
		
		switch (URI) {
		case "employees/past":
			//if(req.getSession(false)!=null) { //if the user is logged in
			ec.getPastReimbursements(res); //how do we send in the user's id?
			//} else {
			//	res.setStatus(403); //forbidden client error
			//}
			break;
			
		case "employees/pending":
			//if(req.getSession(false)!=null) { //if the user is logged in
			ec.getPendingReimbursements(res);
			//} else {
			//	res.setStatus(403); //forbidden client error
			//}
			break;
			
		case "employees/add":
			//if(req.getSession(false)!=null) { //if the user is logged in
			//do the add reimbursement method
			//} else {
			//	res.setStatus(403); //forbidden client error
			//}
			break;
			
		case "managers/all":
			//if(req.getSession(false)!=null) { //if the user is logged in
			mc.getAllTickets(res);
			//} else {
			//	res.setStatus(403); //forbidden client error
			//}
			break;
			
		case "managers/filter":
			//if(req.getSession(false)!=null) { //if the user is logged in
			mc.getTicketsByStatus(req, res);
			//} else {
			//	res.setStatus(403); //forbidden client error
			//}
			break;
			
		case "login":
			lc.login(req, res);
		} 
		
	}
	
	//this sends every request it gets to the doGet method, so we only have to write the switch statement once. 
	//so basically every request ends up hitting the switch, and we'll differentiate get from post in the controllers
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req, res);
	}
}
