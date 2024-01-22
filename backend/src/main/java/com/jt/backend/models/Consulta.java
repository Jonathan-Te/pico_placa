package com.jt.backend.models;

import java.time.LocalDateTime;

public class Consulta {
	private int idConsulta;
	private String placa;
	private LocalDateTime fechaConsulta;
	private LocalDateTime fechaConsultada;
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
