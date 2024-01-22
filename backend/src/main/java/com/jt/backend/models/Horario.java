package com.jt.backend.models;

import java.time.LocalDateTime;

public class Horario {
	private int idHorario;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalDateTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
	}
	
	
}
