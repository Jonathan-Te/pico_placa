package com.jt.backend.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jt.backend.dbconnection.DataBaseConnection;

public abstract class ValidacionServices {
	
	public static String validarAntesHoy() {
		Connection connection = DataBaseConnection.getConnection();
		 try {
	            // Your database operations here...
			 String query = "SELECT * FROM dia";

		      // create the java statement
		      Statement st = connection.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String nombre = rs.getString("nombre");
		        String restriccion = rs.getString("restriccion");
		        
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s, %s, %s\n", id, nombre, restriccion);
		        return Integer.toString(id)+ " "+ nombre+" "+restriccion ;
		      }
		      st.close();
	        } catch (SQLException e) {
	            System.err.println("SQL error: " + e.getMessage());
	            return "no sirve";
	        } finally {
	            // Close the connection when done
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    System.err.println("Error closing connection: " + e.getMessage());
	                }
	            }
	            return "cerrado";
	        }
		
	}
}
