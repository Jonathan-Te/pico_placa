package com.jt.backend.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name="Consulta")
public class Consulta { //esto es para el historial
	
	@Id	
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int idConsulta;
	@Column 
	@Getter
	@Setter
	private String placa;
	@Column(name="fechaConsulta")
	@Getter
	@Setter
	private String fechaConsulta; //Actual
	@Column(name="fechaConsultada")
	@Getter
	@Setter
	private String fechaConsultada; //Dia en la que se requiere validar pico y placa
	@Column(name="puedeCircular")
	@Getter
	@Setter
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
