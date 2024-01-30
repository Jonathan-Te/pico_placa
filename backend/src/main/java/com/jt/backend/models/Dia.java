package com.jt.backend.models;

public class Dia {
	private int idDia;
	private String nombreDia;
	private String placasRestriccion;
	private int idHorario;
	
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public int getIdDia() {
		return idDia;
	}
	public void setIdDia(int idDia) {
		this.idDia = idDia;
	}
	public String getNombreDia() {
		return nombreDia;
	}
	public void setNombreDia(String nombreDia) {
		this.nombreDia = nombreDia;
	}
	public String getPlacasRestriccion() {
		return placasRestriccion;
	}
	public void setPlacasRestriccion(String placasRestriccion) {
		this.placasRestriccion = placasRestriccion;
	}
	@Override
	public String toString() {
		return "Dia [idDia=" + idDia + ", nombreDia=" + nombreDia + ", placasRestriccion=" + placasRestriccion
				+ ", idHorario=" + idHorario + "]";
	}
	

}
