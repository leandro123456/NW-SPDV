package com.lgg.nticxs.web.model;

public class SimpleAlumno {
	private String nombre;
	private String materia;
	private String nameforfilter;
	private String matterforfilter;
	
	public SimpleAlumno(String nombre, String materia) {
		this.nombre= nombre;
		this.materia = materia;
		this.nameforfilter = nombre.replaceAll(" ", ".");
		this.matterforfilter = materia.replaceAll(" ", "");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getNameforfilter() {
		return nameforfilter;
	}

	public void setNameforfilter(String nameforfilter) {
		this.nameforfilter = nameforfilter;
	}

	public String getMatterforfilter() {
		return matterforfilter;
	}

	public void setMatterforfilter(String matterforfilter) {
		this.matterforfilter = matterforfilter;
	}
	
	
}
