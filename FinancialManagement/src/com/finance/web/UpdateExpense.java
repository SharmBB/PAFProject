package com.finance.web;
import com.finance.dao.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateExpense")
public class UpdateExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		String division = request.getParameter("division");
		String type = request.getParameter("type");
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		float total = Float.parseFloat(request.getParameter("total"));
		
		boolean isTrue;
		
		isTrue = ExpenseDAO.updateExpense(id, date, division, type, quantity, total);
				
		if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("ViewExpense.jsp");
				dis.forward(request, response);
				
		}else {
				RequestDispatcher dis2 = request.getRequestDispatcher("UpdateExpense.jsp");
				dis2.forward(request, response);
		}
	}

}
