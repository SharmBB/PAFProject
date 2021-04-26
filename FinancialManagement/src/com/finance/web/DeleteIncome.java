package com.finance.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.finance.dao.IncomeDAO;


@WebServlet("/DeleteIncome")
public class DeleteIncome extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean isTrue;
		
		isTrue = IncomeDAO.deleteIncome(id);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ViewIncome.jsp");
			dis.forward(request, response);
		
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("DeleteIncome.jsp");
			dis2.forward(request, response);
		}
	}

}
