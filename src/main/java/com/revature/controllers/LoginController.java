package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {

	private ObjectMapper om = new ObjectMapper(); //lets us work with json
	private LoginService ls = new LoginService();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) { //make sure we're reading a POST request
			BufferedReader reader = req.getReader(); //BufferedReader is how we read each line of our body
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line!=null) { //while there are still lines...
				sb.append(line); //add the line 
				line = reader.readLine(); //move on to the next line
			}
			
			//all of this stuff above gets the json string, and we put it into the body variable below
			
			String body = new String(sb);
			
			LoginDTO loginDTO = om.readValue(body, LoginDTO.class); //using object mapper, read the JSON string & make it into a LoginDTO object
			//aka reads the value of your body variable, putting it into an object, in this case the LoginDTO
			
			if(ls.login(loginDTO.username, loginDTO.password)) { //if the login service method returns true based on the provided credentials...
				HttpSession ses = req.getSession(); //start a new session
				
				ses.setAttribute("user", loginDTO);
				ses.setAttribute("loggedin", true);
				
				res.setStatus(200);
				res.getWriter().print("Login Successful"); //won't be seen by user, but it helps when debugging with postman
			}else {
				HttpSession ses = req.getSession(false);
				if (ses != null) { //more likely scenario
					ses.invalidate(); //basically deletes the session, it will be garbage collected (hence logging out)
				}
				res.setStatus(401); //unauthorized (in this case, cause their login credentials failed)
				res.getWriter().print("Login Failed");
			} 	
			
		}  
		
		
		
	}

}
	//control flow, if user_role = "Employee" send them to the EmployeeController and if user_role = "Manager" send them to the ManagerController
	
	
	

