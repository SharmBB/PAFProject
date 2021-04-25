package com.servlet.finance;

import com.finance.dao.IncomeDAO;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("income")
public class income {
	
	@POST  
    @Path("/add")  
    public Response addIncome(  
        @FormParam("date") String  date,  
        @FormParam("division") String Division,  
        @FormParam("total") float Total,
        @FormParam ("remarks")String Remark) { 
		 IncomeDAO.insertIncome(date, Division, Total, Remark);
	
        return Response.status(200)  
            .entity(" Income  added successfuly!<br> Id: "+date+"<br> Name: " + Division+"<br> Price: "+Total)  
            .build();  
    }  

}
