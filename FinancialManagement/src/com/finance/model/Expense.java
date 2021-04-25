package com.finance.model;

public class Expense {
	
	private int id;
	private String date;
	private String division;
	private String type;
	private int quantity;
	private float total;
	
	public Expense(int id, String date, String division, String type, int quantity, float total) {
		
		this.id = id;
		this.date = date;
		this.division = division;
		this.type = type;
		this.quantity = quantity;
		this.total = total;
	}
	
	public int getid() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getDivision() {
		return division;
	}

	public String getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getTotal() {
		return total;
	}

	
	
	
	
	
	
	
	
	
}
