package com.servlet.finance;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.finance.dao.IncomeDAO;
import com.finance.model.Income;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("vIncome")
public class ViewIncome {
	@POST  
    @Path("/view")  
    public Response addIncome(  
        @FormParam("sDate") String sDate,  
        @FormParam("eDate") String eDate,  
        @FormParam ("division")String division) { 
	
		List<Income> incDetails = IncomeDAO.displaySelected(division, sDate, eDate);
	
        return Response.status(200)
            .entity("Wait")  
            .build();  
    }  

}
