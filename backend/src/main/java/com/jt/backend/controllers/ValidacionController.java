package com.jt.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.backend.dto_models.ConsultaDto;
import com.jt.backend.models.Consulta;
import com.jt.backend.services.FechasHoraServices;


@RestController

public class ValidacionController {

	@PostMapping("/validar")
	public Boolean validarPicoPlaca(ConsultaDto consultaDtoObj) {
		boolean fechavalida = FechasHoraServices.
		
		return true;
	}
	
}
