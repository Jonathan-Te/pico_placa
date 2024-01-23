package com.jt.backend.models;

import java.sql.Time;
import java.time.LocalDateTime;

public class Horario {
	private int idHorario;
	private Time horaInicio;
	private Time horaFin;
	private int idSecundario;
	public int getIdSecundario() {
		return idSecundario;
	}
	public void setIdSecundario(int idSecundario) {
		this.idSecundario = idSecundario;
	}
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	
	
}
