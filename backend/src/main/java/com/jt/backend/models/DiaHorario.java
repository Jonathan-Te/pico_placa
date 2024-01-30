package com.jt.backend.models;

import java.util.ArrayList;

public class DiaHorario {
	private Dia dia;
	private ArrayList <Horario> horarioList;
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public ArrayList<Horario> getHorarioList() {
		return horarioList;
	}
	public void setHorarioList(ArrayList<Horario> horarioList) {
		this.horarioList = horarioList;
	}

}
