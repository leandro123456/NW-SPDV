package com.lgg.nticxs.web.model;

public class SimpleAlumnoFilter {
	private String nombre;
	private String nameforfilter;
	
	public SimpleAlumnoFilter(String nombre) {
		this.nombre= nombre;
		this.nameforfilter = nombre.replaceAll(" ", ".");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNameforfilter() {
		return nameforfilter;
	}

	public void setNameforfilter(String nameforfilter) {
		this.nameforfilter = nameforfilter;
	}
	
	
}
