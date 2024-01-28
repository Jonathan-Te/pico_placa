package com.jt.backend.models;

import java.time.LocalDateTime;

public class Consulta { //esto es para el historial
	private int idConsulta;
	private String placa;
	private LocalDateTime fechaConsulta; //Actual
	private LocalDateTime fechaConsultada; //Dia en la que se requiere validar pico y placa
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
	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public LocalDateTime getFechaConsultada() {
		return fechaConsultada;
	}
	public void setFechaConsultada(LocalDateTime fechaConsultada) {
		this.fechaConsultada = fechaConsultada;
	}
	public Boolean getCircula() {
		return circula;
	}
	public void setCircula(Boolean circula) {
		this.circula = circula;
	}
	
	
}
