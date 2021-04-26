package com.finance.model;

public class Income {
	private int id;
	private String date;
	private String division;
	private float total;
	private String remarks;
	
	public Income(int id, String date, String division, float total, String remarks) {
		super();
		this.id = id;
		this.date = date;
		this.division = division;
		this.total = total;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	

	public String getDate() {
		return date;
	}

	

	public String getDivision() {
		return division;
	}

	public float getTotal() {
		return total;
	}


	public String getRemarks() {
		return remarks;
	}

	
	
	

}
