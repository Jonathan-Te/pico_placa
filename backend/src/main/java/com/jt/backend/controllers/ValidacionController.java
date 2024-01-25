package com.jt.backend.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jt.backend.dto_models.ConsultaDto;
import com.jt.backend.dto_models.RespuestaDto;
import com.jt.backend.models.Consulta;
import com.jt.backend.services.FechasHoraServices;
import com.jt.backend.services.ValidacionServices;


@RestController
public class ValidacionController {

	@PostMapping("/validar" )
	public ResponseEntity<?> validarPicoPlaca(@RequestBody ConsultaDto consultaDtoObj) {
		//FechaConsulta es la fecha es la que se efectua la consulta
		HttpStatus responseCode = HttpStatus.ACCEPTED;
		
		if (FechasHoraServices.validarFecha(consultaDtoObj.getFechaConsulta())) {
			Date fechaConsulta = new Date();
			fechaConsulta=FechasHoraServices.tranformaStringToDate(consultaDtoObj.getFechaConsulta());
			//Fecha consultada es la fecha en la que se requiere conocer si se puede circular con dicha placa.
			Date fechaConsultada = new Date();
			if (FechasHoraServices.validarFecha(consultaDtoObj.getFechaConsultada())) {
				fechaConsultada=FechasHoraServices.tranformaStringToDate(consultaDtoObj.getFechaConsultada());
			
				if ( FechasHoraServices.compararFechas(fechaConsulta, fechaConsultada)) {
					responseCode=HttpStatus.OK;
					//TODO validar Placa
					
					if (ValidacionServices.validarCirculacion(consultaDtoObj.getPlaca(),fechaConsultada).getMensaje()=="Error en base de datos") {
						responseCode=HttpStatus.INTERNAL_SERVER_ERROR;
						return ResponseEntity.status(responseCode).body("Error en base de datos");
					}
					else {	
					return ResponseEntity.status(responseCode).body(ValidacionServices.validarCirculacion(consultaDtoObj.getPlaca(),fechaConsultada));
					}
					
				}
				
				else {
					responseCode=HttpStatus.NOT_IMPLEMENTED;
					return ResponseEntity.status(responseCode).body("Ingrese una fecha posterior o igual a la fecha actual");
				}
				
				
			
			}
			else {
				//TODO 
				responseCode=HttpStatus.BAD_REQUEST;
				
				return ResponseEntity.status(responseCode).body("Ingrese una fecha valida");
			}
			
		
		}
		else {
			//TODO NO es una fecha valida el fecha Consulta 
			responseCode=HttpStatus.BAD_REQUEST;
			return ResponseEntity.status(responseCode).body("Verifique la fecha del sistema");
		}
		
		
		
		
		
		
	}
	
}
