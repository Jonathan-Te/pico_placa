package com.jt.backend.services;
import java.util.Date;


public abstract class FechasHoraServices {
	public Date tranformaStringToDate(String fechaHora) {
		//2023-01-12 18:28
		
		int anio = Integer.parseInt(fechaHora.substring(0,4));
		int mes = Integer.parseInt(fechaHora.substring(5,7));
		int dia = Integer.parseInt(fechaHora.substring(8,10));
		int hora = Integer.parseInt(fechaHora.substring(11,13));
		int minuto = Integer.parseInt(fechaHora.substring(14,16));
		
		
		
		Date nuevo=new Date(anio,mes,dia,hora,minuto);
		
		
		
		return nuevo;
	} 
	
	public boolean compararFechas(Date fecha1,Date fecha2) {
		//fecha 1 mayor a fecha 2 = false
		//Se espera en fecha uno el hoy
		//fecha 1 menor o igual a fecha 2 = true
		return  (fecha1.before(fecha2));
		
	}
}
