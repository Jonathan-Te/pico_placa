package com.jt.backend.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.jt.backend.dbconnection.DataBaseConnection;
import com.jt.backend.models.Dia;
import com.jt.backend.models.DiaHorario;
import com.jt.backend.repositories.DiaHorarioRepository;

public abstract class ValidacionServices {
	
	public static boolean validarCirculacion(String placa, Date fechaConsultada) {
		
		//consultar el dia, horario y placas en restriccion para el dia consultado.
		if (fechaConsultada.getDay() > 0 && fechaConsultada.getDay() < 6) {
			
			Object diaHorario = DiaHorarioRepository.contultarDiaHorario(fechaConsultada.getDay());
			
			if (diaHorario instanceof String) {
				System.out.print("Herror base de datos");
				return false;
			}
			else {
				DiaHorario diaHorarioCast = (DiaHorario) diaHorario;
				return validarFechaPlaca( placa.substring(placa.length()), diaHorarioCast.getDia());
			}
			
			
			
		}
		
		else {
			
			return true;//Sabado y domingo si hay circulacion
		}
		
	}
	public static boolean validarFechaPlaca (String ulitmoDigito,Dia dia) {
		if (dia.getPlacasRestriccion().contains(ulitmoDigito))
			return false;
		else		
			return true;
	}
}
