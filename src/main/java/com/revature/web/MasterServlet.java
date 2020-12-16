package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;

public class MasterServlet extends HttpServlet{
	//private AvengersController ac = new AvengersController();
	private LoginController lc = new LoginController();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json"); //its JSON the servlet is sending back ;)
		
		res.setStatus(404); //if no cases in the switch statement handle it, we default to 404
		
		final String URI = req.getRequestURI().replace("/Project-1/", "");
		
		switch (URI) {
		case "employees":
			if(req.getSession(false)!=null) { //if the user is logged in
			//send a redirect to the employees page
			//do some stuff through the employee controller
			} else {
				res.setStatus(403); //forbidden client error
			}
		case "managers":
			if(req.getSession(false)!=null) { //if the user is logged in
			//send a redirect to the managers page 
			//do some stuff through the employee controller
			} else {
				res.setStatus(403); //forbidden client error
			}
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
