package com.jt.backend.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jt.backend.dbconnection.DataBaseConnection;
import com.jt.backend.models.Consulta;
import com.jt.backend.models.Dia;
import com.jt.backend.models.DiaHorario;
import com.jt.backend.models.Horario;

public class DiaHorarioRepository {

	public static Object contultarDiaHorario(int diaSemana) {
		DiaHorario diaHorario = new DiaHorario();

		Connection connection = DataBaseConnection.getConnection();
		try {
			// Your database operations here...
			String query = "Select * From Dia  where id=" + diaSemana + ";";
			System.out.print("--------------" + diaSemana + "---------------------");

			// create the java statement
			Statement st = connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				Dia dia = new Dia();
				dia.setIdDia(rs.getInt("id"));
				dia.setNombreDia(rs.getString("nombre"));
				dia.setPlacasRestriccion(rs.getString("restriccion"));
				dia.setIdHorario(rs.getInt("idHorario"));
				diaHorario.setDia(dia);

			}
			st.close();

			// String query2 = "Select * From Horario where
			// id="+diaHorario.getDia().getIdHorario()+";";
			String query2 = "Select * From Horario";

			// create the java statement
			Statement st2 = connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs2 = st2.executeQuery(query2);

			// iterate through the java resultset
			ArrayList<Horario> horarioList = new ArrayList<Horario>();

			while (rs2.next()) {
				Horario horario = new Horario();
				horario.setIdHorario(rs2.getInt("id"));
				horario.setHoraInicio(rs2.getTime("horaInicio"));
				horario.setHoraFin(rs2.getTime("horaFin"));
				horario.setIdSecundario(rs2.getInt("idSecundario"));
				// horario.toString();
				horarioList.add(horario);

			}

			diaHorario.setHorarioList(horarioList);

			st2.close();

			return diaHorario;

		} catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage());
			return e.getMessage() + "no sirve";
		} /*
			 * finally { // Close the connection when done if (connection != null) { try {
			 * connection.close(); } catch (SQLException e) {
			 * System.err.println("Error closing connection: " + e.getMessage()); } } return
			 * "cerrado"; }
			 */

	}

	
}
