package com;

//Model
import model.Product;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

//SET PATH ..............................................
@Path("/ProductService")
public class ServiceProduct {

	// Object
	Product productsObj = new Product();

	// Read
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)

	public String readProducts() {

		return productsObj.readProducts();
	}

	// Insert
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertProducts(

			@FormParam("Product_Code") String Product_Code,
			@FormParam("Prod_Name") String Prod_Name,
			@FormParam("Contributors") String Contributors, 
			@FormParam("Email") String Email,
			@FormParam("Price") String Price) {

		String output = productsObj.insertProducts(Product_Code, Prod_Name, Contributors, Email, Price);
		return output;
	}

	// Update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProducts(String productsData) {

		// Convert the input string to a JSON object
		JsonObject productsObject = new JsonParser().parse(productsData).getAsJsonObject();

		// Read the values from the JSON object
		String Prod_ID = productsObject.get("Prod_ID").getAsString();
		String Product_Code = productsObject.get("Product_Code").getAsString();
		String Prod_Name = productsObject.get("Prod_Name").getAsString();
		String Contributors = productsObject.get("Contributors").getAsString();
		String Email = productsObject.get("Email").getAsString();
		String Price = productsObject.get("Price").getAsString();

		String output = productsObj.updateProducts(Prod_ID, Product_Code, Prod_Name, Contributors, Email, Price);

		return output;
	}

	// Delete
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProducts(String productsData) {

		// Convert the input string to an XML document
		Document doc = Jsoup.parse(productsData, "", Parser.xmlParser());

		// Read the value from the element <ProductID>
		String Prod_ID = doc.select("Prod_ID").text();

		String output = productsObj.deleteProduct(Prod_ID);
		return output;
	}

}
