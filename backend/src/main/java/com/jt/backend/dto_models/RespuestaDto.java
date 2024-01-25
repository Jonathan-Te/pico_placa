package com.jt.backend.dto_models;

public class RespuestaDto {
	private boolean circula;
	private String mensaje;
	public boolean isCircula() {
		return circula;
	}
	public void setCircula(boolean circula) {
		this.circula = circula;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
