package com.revature.models;

public class ReimbursementDTO {
	
	public int reimbursementId;
	
	public int typeId;
	
	public int statusId;
	
	public double amount;
	
	public String description;

	//the constructor for statusId ONLY (filter by status)
	public ReimbursementDTO(int statusId) {
		super();
		this.statusId = statusId;
	}
	
	//the constructor for reimbursementID and statusID (resolve ticket) 
	public ReimbursementDTO(int reimbursementId, int statusId) {
		super();
		this.reimbursementId = reimbursementId;
		this.statusId = statusId;
	}

	
	//the constructor for adding a NEW reimbursement
	public ReimbursementDTO(int statusId, double amount, int typeId) {
		super();
		this.typeId = typeId;
		this.description = description;
		this.amount = amount;
	}

	public ReimbursementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
