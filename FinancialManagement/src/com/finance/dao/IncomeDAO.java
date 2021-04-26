package com.finance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.finance.model.*;

public class IncomeDAO {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;		
	private static boolean success = false;
	
	
	
	public static List<Income> display(){
		
		ArrayList<Income> inc = new ArrayList<>();
		
		try {
			con = DBConnect.getConection();
			stmt = con.createStatement();
			String sql = "select * from income";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String date = rs.getString(2);
				String division = rs.getString(3);
				float total = rs.getFloat(4);
				String remarks = rs.getString(5);
				
				Income i = new Income(id, date, division, total, remarks);
				
				inc.add(i);
			}
			
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
			
		return inc;
}
	
	
	
public static List<Income> displaySelected(String div, String sDate, String eDate){
		
		ArrayList<Income> inc = new ArrayList<>();
		
		try {
			con = DBConnect.getConection();
			stmt = con.createStatement();
			String sql = "select * from income WHERE Division = '"+div+"' AND IDate between '"+sDate+"' and '"+eDate+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String date = rs.getString(2);
				String division = rs.getString(3);
				float total = rs.getFloat(4);
				String remarks = rs.getString(5);
				
				Income i = new Income(id, date, division, total, remarks);
				
				inc.add(i);
			}
			
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
			
		return inc;
}

	public static boolean insertIncome(String date, String division, float total, String remarks) {
		
		
		try {
			con = DBConnect.getConection();
			stmt = con.createStatement();
			
			String sql = "insert into income values (0, '"+date+"', '"+division+"', '"+total+"', '"+remarks+"')";
			
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				success = true;
			} else {
				success = false;
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
			
		return success;
	}
	
	public static boolean updateIncome(int id, String date, String division, float total, String remarks) {
		
		try {
			con = DBConnect.getConection();
			stmt = con.createStatement();
			
			String sql = "update income set IDate='"+date+"', Division='"+division+"', Total = '"+total+"' , Remarks = '"+remarks+"' where InvoiceID = '"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				success = true;
			} else {
				success = false;
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return success;
	}
	
	public static boolean deleteIncome(int id) {
		
		try {
			con = DBConnect.getConection();
			stmt = con.createStatement();
			
			String sql = "delete from income where InvoiceID = '"+id+"' ";
			
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				success = true;
			} else {
				success = false;
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return success;
	}
	
	
	
}
