package com.jt.backend.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import com.jt.backend.dbconnection.DataBaseConnection;
import com.jt.backend.models.Consulta;



public class ConsultaRepository {
	public static boolean guardarConsulta(Consulta consulta) {

		Connection connection = DataBaseConnection.getConnection();
		try {
			// Your database operations here...
			String query = "Insert into Consulta (placa,fechaConsulta,fechaConsultada,puedeCircular) values ('"
					+ consulta.getPlaca() + "','" + consulta.getFechaConsulta() + "','" + consulta.getFechaConsultada()
					+ "'," + consulta.getCircula() + ");";

			// create the java statement
			Statement st = connection.createStatement();
			System.out.println(query);

			// execute the query, and get a java resultset
			st.executeUpdate(query);

			// iterate through the java resultset

			st.close();
			return true;
		} catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage());
			return false;
		}


	}
	public static ArrayList<Consulta> consultarHistorialConsultas() {

		 ArrayList<Consulta> consultaArreglo=new ArrayList<Consulta>();
		
		Connection connection = DataBaseConnection.getConnection();
		try {
			// Your database operations here...
			String query = "Select * From Consulta;";
			

			// create the java statement
			Statement st = connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				Consulta consulta = new Consulta();
				
				
				consulta.setIdConsulta(rs.getInt("id"));
				consulta.setPlaca(rs.getString("placa"));
				consulta.setFechaConsulta(rs.getString("fechaConsulta"));
				consulta.setFechaConsultada(rs.getString("fechaConsultada"));
				consulta.setCircula(rs.getBoolean("puedeCircular"));
				consultaArreglo.add(consulta);

			}
			st.close();

				
			Collections.reverse(consultaArreglo); //TODO
			return consultaArreglo;

		} catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage());
			return consultaArreglo;
		}
	}

}
