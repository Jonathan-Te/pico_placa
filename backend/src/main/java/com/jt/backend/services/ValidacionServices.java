package com.jt.backend.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jt.backend.dbconnection.DataBaseConnection;
import com.jt.backend.dto_models.RespuestaDto;
import com.jt.backend.models.Dia;
import com.jt.backend.models.DiaHorario;
import com.jt.backend.models.Horario;
import com.jt.backend.repositories.DiaHorarioRepository;

public abstract class ValidacionServices {
	
	public static RespuestaDto validarCirculacion(String placa, Date fechaConsultada) {
		
		RespuestaDto respuestaDto =new RespuestaDto();
		//consultar el dia, horario y placas en restriccion para el dia consultado.
		if (fechaConsultada.getDay() > 0 && fechaConsultada.getDay() < 6) {
			
			Object diaHorario = DiaHorarioRepository.contultarDiaHorario(fechaConsultada.getDay());
			
			if (diaHorario instanceof String) {
				System.out.print("Error base de datos");
				respuestaDto.setCircula(false);
				respuestaDto.setMensaje("Error en base de datos");
				return respuestaDto;//Sabado y domingo si hay circulacion
				
			}
			else {
				DiaHorario diaHorarioCast = (DiaHorario) diaHorario;
				System.out.println("Funcion validar circulacion diaHorario "+ diaHorarioCast.getDia().getNombreDia());
				return validarFechaPlaca( placa.substring(placa.length()-1), diaHorarioCast,fechaConsultada);
				
				
			}
			
			
			
		}
		
		else {
			respuestaDto.setCircula(true);
			respuestaDto.setMensaje("Dia consultado es fin de semana");
			return respuestaDto;//Sabado y domingo si hay circulacion
		}
		
	}
	public static RespuestaDto validarFechaPlaca (String ulitmoDigito,DiaHorario diaHorario, Date fechaConsultada) {
		System.out.println("Funcion validar fecha Placa ultimo digito"+ ulitmoDigito +"get placa restriccion"+ diaHorario.getDia().getPlacasRestriccion());
		RespuestaDto respuestaDto =new RespuestaDto();
		if (diaHorario.getDia().getPlacasRestriccion().contains(ulitmoDigito)) {
			System.out.println(diaHorario.getHorarioList().size());
			
			for (Horario horario: diaHorario.getHorarioList()) {
				Date fechaInicio=new Date(fechaConsultada.getYear(),fechaConsultada.getMonth(),fechaConsultada.getDate(),horario.getHoraInicio().getHours(),horario.getHoraInicio().getMinutes());
				Date fechaFin=new Date(fechaConsultada.getYear(),fechaConsultada.getMonth(),fechaConsultada.getDate(),horario.getHoraFin().getHours(),horario.getHoraFin().getMinutes());
				if (fechaConsultada.after(fechaInicio) && fechaConsultada.before(fechaFin)) {
					respuestaDto.setCircula(false);
					respuestaDto.setMensaje("No circula en "+formatoFecha(fechaConsultada)+". Se encuentra entre "+formatoFecha(fechaInicio)+" y "+ formatoFecha(fechaFin));
					System.out.println(respuestaDto.getMensaje());
					return respuestaDto;
				}
			}
			respuestaDto.setCircula(true);
			respuestaDto.setMensaje("Fuera de Horario de Restriccion");
			return respuestaDto;
		}
					
		else {
			respuestaDto.setCircula(true);
			respuestaDto.setMensaje("Fuera de Dias de Restriccion");
			return respuestaDto;
		}		
			
	}
	public static String formatoFecha(Date fecha) {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");    
        String fechaFormateada = formato.format(fecha);
		return fechaFormateada;
	}
}
