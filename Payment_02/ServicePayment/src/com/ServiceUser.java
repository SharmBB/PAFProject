package com;

//coded by kithushan
//Model
import model.User;

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
@Path("/UserService")
public class ServiceUser {

	User user = new User();
	
	// Read
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)

		public String readPayment() {

			return user.readUser();
		}
		
		// Insert
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertUser(

				@FormParam("name") String name,
				@FormParam("email") String email,
				@FormParam("phoneNo") String phoneNo,
				@FormParam("password") String password
				) {

			String output = user.insertUser(name, email, phoneNo, password);
			return output;
		}

		// Update
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateUser(String userData) {

			// Convert the input string to a JSON object
			JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();

			// Read the values from the JSON object
			String id = userObject.get("id").getAsString();
			String name = userObject.get("name").getAsString();
			String email = userObject.get("email").getAsString();
			String phoneNo = userObject.get("phoneNo").getAsString();
			String password = userObject.get("password").getAsString();
			

			String output = user.updateUser(id, name, email, phoneNo, password);

			return output;
		}

		
		// Delete
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteUser(String userData) {

			// Convert the input string to an XML document
			Document doc = Jsoup.parse(userData, "", Parser.xmlParser());

			// Read the value from the element <ProductID>
			String id = doc.select("id").text();

			String output = user.deleteUser(id);
			return output;
		}
}
