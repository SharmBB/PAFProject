<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Expense</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	<script type="text/javascript">
        function validate(){
        	
            	alert ("Data Deleted Successfully!");
            	
        }
        
        </script>
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div>
				<a href="index.jsp" class="navbar-brand"> Accounts </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="ViewExpense.jsp"
					class="nav-link">  View Expenses</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li><a href="Expense.jsp"
					class="nav-link"> Add Expenses</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="ViewIncome.jsp"
					class="nav-link"> View Incomes </a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li><a href="Income.jsp"
					class="nav-link"> Add Income</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li><a href="Report.jsp"
					class="nav-link"> Reports </a></li>
			</ul>
		</nav>
	</header>
	<br><br><br><br><br><br><br>

	<%
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		String division = request.getParameter("division");
		String type = request.getParameter("type");
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		float total = Float.parseFloat(request.getParameter("total"));
	%>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

	<form action = "DeleteExpense" method = "post">
		
		<fieldset class="form-group">
		InvoiceID <input type = "text" name ="id" value = "<%= id %>" readonly><br>
		</fieldset>
		
		<fieldset class="form-group">
		Date<br> <input type = "text" name = "date" value ="<%= date %>" readonly> <br><br>
		Division <select id = "div" name = "division" >
		<option value="Hotel Room">Hotel Room</option>
    	<option value="Banquet Hall">Banquet Hall</option>
    	<option value="Restaurant">Restaurant</option>
    	<option value="Transport">Transport</option>
    	<option value="Other">Other</option>
		</select> <br>
		</fieldset>
		
		<fieldset class="form-group">
		Type <br> <input type = "text" name = "type" value ="<%= type %>" readonly> <br>
		</fieldset>
		
		<fieldset class="form-group">
		Quantity <br> <input type = "text" name = "quantity" value ="<%= quantity %>" readonly> <br>
		</fieldset>
		
		<fieldset class="form-group">
		Total <br> <input type ="text" name = "total" value ="<%= total %>" readonly> 
		</fieldset>
		
		<button  type ="submit" name = "submit" onClick = "return validate();" class="btn btn-danger">Delete Expense</button>
	
	</form> 
	</div>
	</div>
	</div>



</body>
</html>