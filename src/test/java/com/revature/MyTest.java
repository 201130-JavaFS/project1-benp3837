package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class MyTest {
	
	private LoginService ls = new LoginService();
	private ReimbursementService rs = new ReimbursementService();
	private UserService us = new UserService();
	
//login service tests
	
	@Test
	public void canLogin() {
		assertEquals(ls.login("Benp3837", "Password"), true);
	}
	
	@Test
	public void canKillInvalidLogin() {
		assertEquals(ls.login("FakeName", "FakePassword"), false);
	}


//reimbursement service tests
	
	
	//get past----
	@Test
	public void canReturnPastTickets() {
		assertNotEquals(rs.getPastReimbursements(), null);
	}
	
	
	//get pending----
	@Test
	public void canReturnPendingTickets() {
		assertNotEquals(rs.getPendingReimbursements(), null);
	}
	
	
	//get all----
	@Test
	public void canSeeAllTickets() {
		assertNotEquals(rs.viewAllTickets(), null);
	}
	
	
	
	//filter-----
	@Test 
	public void canKillLowFilterInput() {
		assertEquals(rs.filterByStatus(0), null);
	}
	
	@Test 
	public void canKillHighFilterInput() {
		assertEquals(rs.filterByStatus(4), null);
	}
	
	@Test
	public void canReturnValidFilterInput() {
		assertNotEquals(rs.filterByStatus(2), null);
	}

	
//user service tests
	@Test
	public void canGetUserByUsername() {
		assertEquals(us.getUser("Benp3837").getFirstName(), "Ben");
	}
	
	@Test
	public void canKillInvalidUsername() {
		assertNull(us.getUser("FakeUser"));
	}
	
}
