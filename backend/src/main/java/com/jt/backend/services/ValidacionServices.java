package com.jt.backend.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jt.backend.dbconnection.DataBaseConnection;
import com.jt.backend.dto_models.RespuestaDto;
import com.jt.backend.models.Consulta;
import com.jt.backend.models.Dia;
import com.jt.backend.models.DiaHorario;
import com.jt.backend.models.Horario;
import com.jt.backend.repositories.ConsultaRepository;
import com.jt.backend.repositories.DiaHorarioRepository;

public abstract class ValidacionServices {
	
	public static RespuestaDto validarCirculacion(String placa, Date fechaConsultada, Date fechaConsulta) {
		Consulta consulta=new Consulta();
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
				return validarFechaPlaca( placa, diaHorarioCast,fechaConsultada,fechaConsulta);
				
				
			}
			
			
			
		}
		
		else {
			respuestaDto.setCircula(true);
			respuestaDto.setMensaje("El día "+formatoFecha(fechaConsultada) +" es fin de semana, No hay restricción vechicular");
			consulta.setPlaca(placa);
			consulta.setFechaConsulta(formatoFechaBaseDatos(fechaConsulta));
			consulta.setFechaConsultada(formatoFechaBaseDatos(fechaConsultada));
			consulta.setCircula(true);
			ConsultaRepository.guardarConsulta(consulta);
			return respuestaDto;//Sabado y domingo si hay circulacion
		}
		
	}
	public static RespuestaDto validarFechaPlaca (String placa,DiaHorario diaHorario, Date fechaConsultada, Date fechaConsulta) {
		String ulitmoDigito=placa.substring(placa.length()-1);
		System.out.println("Funcion validar fecha Placa ultimo digito"+ ulitmoDigito +"get placa restriccion"+ diaHorario.getDia().getPlacasRestriccion());
		RespuestaDto respuestaDto =new RespuestaDto();
		String respuestaStr="<br>"; 
		Consulta consulta=new Consulta();
		if (diaHorario.getDia().getPlacasRestriccion().contains(ulitmoDigito)) {
			System.out.println(diaHorario.getHorarioList().size());
			
			for (Horario horario: diaHorario.getHorarioList()) {
				Date fechaInicio=new Date(fechaConsultada.getYear(),fechaConsultada.getMonth(),fechaConsultada.getDate(),horario.getHoraInicio().getHours(),horario.getHoraInicio().getMinutes());
				Date fechaFin=new Date(fechaConsultada.getYear(),fechaConsultada.getMonth(),fechaConsultada.getDate(),horario.getHoraFin().getHours(),horario.getHoraFin().getMinutes());
				if (fechaConsultada.after(fechaInicio) && fechaConsultada.before(fechaFin)) {
					respuestaDto.setCircula(false);
					respuestaDto.setMensaje("La placa: " +placa+" NO circula el " + diaHorario.getDia().getNombreDia()+", "+formatoFecha(fechaConsultada)+". <br>Se encuentra entre: <br>"+formatoFecha(fechaInicio)+" - "+ formatoFecha(fechaFin));
					System.out.println(respuestaDto.getMensaje());
					consulta.setPlaca(placa);
					consulta.setFechaConsulta(formatoFechaBaseDatos(fechaConsulta));
					consulta.setFechaConsultada(formatoFechaBaseDatos(fechaConsultada));
					consulta.setCircula(false);
					ConsultaRepository.guardarConsulta(consulta);
					return respuestaDto;
				}
				else {
					respuestaStr=respuestaStr+formatoFecha(fechaInicio)+" - "+ formatoFecha(fechaFin)+"<br>";
				}
			}
			respuestaDto.setCircula(true);
			respuestaDto.setMensaje("La placa " +placa+ " tiene restricción el día "+ diaHorario.getDia().getNombreDia()+", fuera de los horario de restricción: "+ respuestaStr);
			consulta.setPlaca(placa);
			consulta.setFechaConsulta(formatoFechaBaseDatos(fechaConsulta));
			consulta.setFechaConsultada(formatoFechaBaseDatos(fechaConsultada));
			consulta.setCircula(true);
			ConsultaRepository.guardarConsulta(consulta);
			return respuestaDto;
		}
					
		else {
			respuestaDto.setCircula(true);
			respuestaDto.setMensaje("La placa " +placa+ " NO tiene restricción el día "+ diaHorario.getDia().getNombreDia()+", "+formatoFecha(fechaConsultada));
			consulta.setPlaca(placa);
			consulta.setFechaConsulta(formatoFechaBaseDatos(fechaConsulta));
			consulta.setFechaConsultada(formatoFechaBaseDatos(fechaConsultada));
			consulta.setCircula(true);
			ConsultaRepository.guardarConsulta(consulta);
			
			return respuestaDto;
		}		
			
	}
	public static String formatoFecha(Date fecha) {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");    
        String fechaFormateada = formato.format(fecha);
		return fechaFormateada;
	}
	
public static String formatoFechaBaseDatos(Date fecha) {
		
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        String fechaFormateada = formato.format(fecha);
		return fechaFormateada;
	}
}
