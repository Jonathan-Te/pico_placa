package com.jt.backend.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jt.backend.dto_models.ConsultaDto;
import com.jt.backend.dto_models.RespuestaDto;
import com.jt.backend.models.Consulta;
import com.jt.backend.repositories.ConsultaRepository;
import com.jt.backend.services.FechasHoraServices;
import com.jt.backend.services.ValidacionServices;
import com.jt.backend.services.ValidarCamposServices;


@RestController
@CrossOrigin(origins = "*")
public class ValidacionController {

	@PostMapping("/validar" )
	public ResponseEntity<?> validarPicoPlaca(@RequestBody ConsultaDto consultaDtoObj) {
		//FechaConsulta es la fecha es la que se efectua la consulta
		HttpStatus responseCode = HttpStatus.ACCEPTED;
		
		
		if (!ValidarCamposServices.validarPlaca(consultaDtoObj.getPlaca())) {
			responseCode=HttpStatus.BAD_REQUEST;
			return ResponseEntity.status(responseCode).body("Placa Invalida");
		}
		
		
		if (FechasHoraServices.validarFecha(consultaDtoObj.getFechaConsulta())) {
			Date fechaConsulta = new Date();
			fechaConsulta=FechasHoraServices.tranformaStringToDateConsulta(consultaDtoObj.getFechaConsulta());
			//Fecha consultada es la fecha en la que se requiere conocer si se puede circular con dicha placa.
			Date fechaConsultada = new Date();
			if (FechasHoraServices.validarFecha(consultaDtoObj.getFechaConsultada())) {
				fechaConsultada=FechasHoraServices.tranformaStringToDate(consultaDtoObj.getFechaConsultada());
				
			
				if ( FechasHoraServices.compararFechas(fechaConsulta, fechaConsultada)) {
					responseCode=HttpStatus.OK;
					
					Object serviceResult= ValidacionServices.validarCirculacion(consultaDtoObj.getPlaca(),fechaConsultada,fechaConsulta);
					if (((RespuestaDto) serviceResult).getMensaje()=="Error en base de datos") {
						responseCode=HttpStatus.INTERNAL_SERVER_ERROR;
						return ResponseEntity.status(responseCode).body("Error en base de datos");
					}
					else {	
					return ResponseEntity.status(responseCode).body(serviceResult);
					}
					
				}
				
				else {
					responseCode=HttpStatus.NOT_IMPLEMENTED;
					return ResponseEntity.status(responseCode).body("Ingrese una fecha posterior o igual a la fecha actual");
				}
				
				
			
			}
			else {
				
				responseCode=HttpStatus.BAD_REQUEST;
				
				return ResponseEntity.status(responseCode).body("Ingrese una fecha valida");
			}
			
		
		}
		else {
			responseCode=HttpStatus.BAD_REQUEST;
			return ResponseEntity.status(responseCode).body("Verifique la fecha del sistema");
		}
		
		
		
		
		
		
	}
	
	
	@GetMapping("/historial" )
	public ResponseEntity<?> obtenerHistorialConsultas() {
		
		return ResponseEntity.status(HttpStatus.OK).body(ConsultaRepository.consultarHistorialConsultas());
	}
	
}
