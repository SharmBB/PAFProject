<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>
         table, td, th {
            border: 1px solid black;
            
         }
      </style>
      
      <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#sdatepicker").datepicker({ dateFormat: 'yy-mm-dd' });
                $("#edatepicker").datepicker({ dateFormat: 'yy-mm-dd' });
            });
        </script>
        <script type="text/javascript">
        function validate(){
        	var sdate = document.getElementById("sdatepicker");
        	var edate = document.getElementById("edatepicker");
            if (sdate.value == "") { 
            	 alert ("Please Pick A Start Date");
            	 return false;
            }
            
            else if (edate.value == "") { 
           	 alert ("Please Pick An End Date");
           	 return false;
           }
            
            else{
            	alert ("Results Ready");
            	return true;
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
				<li><a href="Report.jsp"
					class="nav-link"> Reports </a></li>
			</ul>
		</nav>
	</header>
	<br><br><br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

<form action = "SelectExpense" method = "post">

	<fieldset>
		From <br> <input type = "text" name = "sDate" id = "sdatepicker"> <br>
		</fieldset>
		
		<fieldset>
		To <br> <input type = "text" name = "eDate" id = "edatepicker"> <br><br>
		</fieldset>
	
	<button type ="submit" name = "submit" onClick = "return validate();" class="btn btn-info">Generate Report</button>
	
	</form> 
	</div>
	</div>
	</div>
	<br><br><br>
	
	<div class="container col-md-10">
		<div class="card">
			<div class="card-body">
	<table>
	<tr>
	<th style="text-align:center; width:200px">Division </th>
	<th style="text-align:center; width:200px">Income</th>
	<th style="text-align:center; width:200px">Expense</th>
	</tr>
	
	<tr>
	<td style="text-align:left">Hotel Rooms</td>
	</tr>
	
	<tr>
	<td style="text-align:left">Banquet Hall</td>
	</tr>
	
	<tr>
	<td style="text-align:left">Restaurant</td>
	</tr>
	
	<tr>
	<td style="text-align:left">Transport</td>
	</tr>
	
	<tr>
	<td style="text-align:left">Other</td>
	</tr>
	
	<tr>
	<td style="text-align:left">Total</td>
	</tr>
	
	</table>
	</div>
	</div>
	</div>
	
	
	
</body>
</html>