package com.jt.backend.models;

import java.time.LocalDateTime;

public class Consulta { //esto es para el historial
	private int idConsulta;
	private String placa;
	private String fechaConsulta; //Actual
	private String fechaConsultada; //Dia en la que se requiere validar pico y placa
	private Boolean circula;
		
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getFechaConsultada() {
		return fechaConsultada;
	}
	public void setFechaConsultada(String fechaConsultada) {
		this.fechaConsultada = fechaConsultada;
	}
	public Boolean getCircula() {
		return circula;
	}
	public void setCircula(Boolean circula) {
		this.circula = circula;
	}
	
	
}
