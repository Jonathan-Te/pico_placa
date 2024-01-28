package com.jt.backend.services;

import java.util.regex.Pattern;

public class ValidarCamposServices {
	public static boolean validarPlaca(String placa) {	
		String regex = "^[a-zA-Z]{3}-\\d{4}$";
		boolean isValid = Pattern.matches(regex, placa);
		System.out.println(isValid ? "Valid input" : "Invalid input");
		return isValid;	
	}

}
