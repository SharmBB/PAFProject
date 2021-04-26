<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Expense</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' });
            });
        </script>
         <script type="text/javascript">
        function validate(){
        	var date = document.getElementById("datepicker");
        	var tot = document.getElementById("total");
            if (date.value == "") { 
            	 alert ("Please Pick Date");
            	 return false;
            }
            
            else if ((tot.value == "") || (tot.value <= 0)) { 
           	 alert ("Please Insert Valid Amount");
           	 return false;
           }
            else{
            	alert ("Data Updated Successfully!");
            	return true;
            }
        }
        
        </script>
        
           <script>
            
            function isInputNumber(evt){
                
                var ch = String.fromCharCode(evt.which);
                
                if(!(/[0-9]/.test(ch))){
                    evt.preventDefault();
                }
                
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
				<li><a href="#"
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
	
	<form action = "UpdateExpense" method = "post">
		
		<fieldset class="form-group">
		InvoiceID <input type = "text" name ="id" value = "<%= id %>" readonly><br>
		</fieldset>
		
		<fieldset class="form-group">
		Date <br> <input type = "text" name = "date" id = "datepicker" value ="<%= date %>"> <br>
		</fieldset>
		
		<fieldset class="form-group">
		Division <select id = "div" name = "division">
		<option value="Hotel Room">Hotel Room</option>
    	<option value="Banquet Hall">Banquet Hall</option>
    	<option value="Restaurant">Restaurant</option>
    	<option value="Transport">Transport</option>
    	<option value="Other">Other</option>
		</select> <br>
		</fieldset>
		
		<fieldset class="form-group">
		Type <br> <input type = "text" name = "type" value ="<%= type %>"> <br>
		</fieldset>
		
		<fieldset class="form-group">
		Quantity <br> <input type = "text" name = "quantity" value ="<%= quantity %>" onkeypress="isInputNumber(event)"> <br>
		</fieldset>
		
		<fieldset class="form-group">
		Total <br> <input type ="text" name = "total" value ="<%= total %>" id = "total" onkeypress="isInputNumber(event)"> 
		</fieldset>
		
		<button type ="submit" name = "submit" onClick = "return validate();" class="btn btn-primary">Update Expense</button>
	
	</form> 
	</div>
	</div>
	</div>




</body>
</html>