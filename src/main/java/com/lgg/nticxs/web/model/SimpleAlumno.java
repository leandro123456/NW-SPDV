package com.lgg.nticxs.web.model;

import com.lgg.nticxs.web.DAO.SimpleMateriaDAO;

public class SimpleAlumno {
	private SimpleMateriaDAO materiaDAO = new SimpleMateriaDAO();
	private String nombre;
	private String materia;
	private String nameforfilter;
	private String matterforfilter;
	private String image;
	
	public SimpleAlumno(String nombre, String materia) {
		this.nombre= nombre;
		this.materia = materia;
		this.nameforfilter = nombre.replaceAll(" ", ".");
		SimpleMateria smateria = materiaDAO.retrieveByIdMateria(materia);
		this.matterforfilter=smateria.getMatterforfilter();
		this.image = smateria.getImage();
	}
	
	public SimpleAlumno(String nameFiltered){
		
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
