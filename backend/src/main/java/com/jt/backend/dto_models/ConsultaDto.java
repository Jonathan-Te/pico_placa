package com.jt.backend.dto_models;

public class ConsultaDto {
	private String placa;
	private String fechaConsulta;
	private String fechaConsultada;
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa.toUpperCase();
	}
	public String getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(String fechaCunsulta) {
		this.fechaConsulta = fechaCunsulta;
	}
	public String getFechaConsultada() {
		return fechaConsultada;
	}
	public void setFechaConsultada(String fechaConsultada) {
		this.fechaConsultada = fechaConsultada;
	}
	
	

}
