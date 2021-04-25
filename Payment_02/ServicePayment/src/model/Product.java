package model;

import java.sql.*;

public class Product {
	// DB Connection
		public Connection connect() {
			Connection con = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/product", "root", "");

				// For testing
				System.out.print("DB Successfully connected");
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.print("DB not connected");
			}

			return con;
		}
		
		// Insert
		public String insertProducts(String Product_Code, String Prod_Name, String Contributors, String Email, String Price) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = " insert into product(`Prod_ID`,`Product_Code`,`Prod_Name`,`Contributors`,`Email`,`Price`)"
						+ " values (?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, Product_Code);
				preparedStmt.setString(3, Prod_Name);
				preparedStmt.setString(4, Contributors);
				preparedStmt.setString(5, Email);
				preparedStmt.setDouble(6, Double.parseDouble(Price));
				
			
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Inserted success";

			} catch (Exception e) {
				output = "Insertion Unsuccess";
				System.err.println(e.getMessage());
			}
			return output;
		}



		// Read
		public String readProducts() {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}

				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>Product_Code</th>" + "<th>Prod_Name</th><th>Contributors</th>"
						+ "<th>Email</th>" + "<th>Price</th></tr>";

				String query = "select * from product";

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query);

				// iterate through the rows in the result set
				while (rs.next()) {

					String Prod_ID   = Integer.toString(rs.getInt("Prod_ID"));
					String Product_Code = rs.getString("Product_Code");
					String Prod_Name = rs.getString("Prod_Name");
					String Contributors = rs.getString("Contributors");
					String Email = rs.getString("Email");
					String Price = Double.toString(rs.getDouble("Price"));
					

					// Add into the html table
					output += "<tr><td>" + Product_Code + "</td>";
					output += "<td>" + Prod_Name + "</td>";
					output += "<td>" + Contributors + "</td>";
					output += "<td>" + Email + "</td>";
					output += "<td>" + Price + "</td>";
					

				}

				con.close();

				// Complete the html table
				output += "</table>";

			} catch (Exception e) {
				output = "Error while reading.";
				System.err.println(e.getMessage());
			}
			return output;
		}

		// Update
		public String updateProducts(String Prod_ID, String Product_Code, String Prod_Name, String Contributors, String Email, String Price) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}

				// create a prepared statement
				String query = "UPDATE product SET Product_Code=?,Prod_Name=?,Contributors=?,Email=?,Price=? WHERE Prod_ID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setString(1, Product_Code);
				preparedStmt.setString(2, Prod_Name);
				preparedStmt.setString(3, Contributors);
				preparedStmt.setString(4, Email);
				preparedStmt.setDouble(5, Double.parseDouble(Price));
				preparedStmt.setInt(6, Integer.parseInt(Prod_ID));
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Successfully Updated";

			} catch (Exception e) {
				output = "Updating unsuccesful .";
				System.err.println(e.getMessage());
			}
			return output;
		}



		// Delete
		public String deleteProduct(String Prod_ID) {
			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}

				// create a prepared statement
				String query = "delete from product where Prod_ID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, Integer.parseInt(Prod_ID));

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Deleted successfully";

			} catch (Exception e) {
				output = "Error while deleting the Product Details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
}
