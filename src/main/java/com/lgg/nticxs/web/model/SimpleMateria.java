package com.lgg.nticxs.web.model;

public class SimpleMateria {
	private String materia;
	private String matterforfilter;
	
	public SimpleMateria(String materia) {
		this.materia = materia;
		this.matterforfilter = materia.replaceAll(" ", "");
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getMatterforfilter() {
		return matterforfilter;
	}

	public void setMatterforfilter(String matterforfilter) {
		this.matterforfilter = matterforfilter;
	}
	
	
}
