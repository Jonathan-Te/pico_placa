package com.jt.backend.services;
import java.util.Date;


public class FechasHoraServices {
	public static boolean validarFecha(String fechaHora) {
		//2023-01-12 18:28
		// TODO colocar en try catch para validar que me llegaron ints
		
		try{
		tranformaStringToDate(fechaHora);
			
		return true;
		
		}
		catch(Exception error) {
			return false;
		}
	}
	
	
	
	
	
	public static Date tranformaStringToDate(String fechaHora) {
		//2023-01-12 18:28
		// TODO colocar en try catch para validar las 
		
		
		int anio = Integer.parseInt(fechaHora.substring(0,4));
		System.out.println("anio"+anio);
		int mes = Integer.parseInt(fechaHora.substring(5,7));
		System.out.println("mes"+mes);
		int dia = Integer.parseInt(fechaHora.substring(8,10));
		System.out.println("dia"+dia);
		int hora = Integer.parseInt(fechaHora.substring(11,13));
		System.out.println("hora"+hora);
		int minuto = Integer.parseInt(fechaHora.substring(14,16));
		System.out.print("minuto"+minuto);
		
		
		
		Date nuevo=new Date(anio-1900,mes-1,dia,hora,minuto);
		
		System.out.print("dia de la semana"+nuevo.getDay());
		
		return nuevo;
	} 
	
	public static boolean compararFechas(Date fecha1,Date fecha2) {
		//fecha 1 mayor a fecha 2 = false
		//Se espera en fecha uno el hoy
		//fecha 1 menor o igual a fecha 2 = true
		return  (fecha1.before(fecha2));
		
	}
}
