package com.finance.web;
import com.finance.dao.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteExpense")
public class DeleteExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean isTrue;
		
		isTrue = ExpenseDAO.deleteExpense(id);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ViewExpense.jsp");
			dis.forward(request, response);
		
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("DeleteExpense.jsp");
			dis2.forward(request, response);
		}
	}

}
