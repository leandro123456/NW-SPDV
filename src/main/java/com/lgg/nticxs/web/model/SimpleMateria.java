package com.lgg.nticxs.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class SimpleMateria {
	
	@Id
	@GeneratedValue
	@Field(name = "_id")
	private String id;
	
	@Field (name = "materia")
	private String materia;
	
	@Field (name = "matterforfilter")
	private String matterforfilter;
	
	@Field (name = "image")
	private String image;
	
	@Field (name = "anio")
	private Integer anio;
	
	@Field (name = "curso")
	private String curso;
	
	@Field (name = "docente")
	private String docente;
	
	public SimpleMateria(){
		//no se usa
	}
	
	public SimpleMateria(String materia, String image) {
		this.materia = materia;
		this.matterforfilter = materia.replaceAll(" ", "");
		this.image = image;
		
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}
	
	
}
