package com.lgg.nticxs.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

	
	

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Materia {
	static final public String ACTIVIDADES = "actividad";
	static final public String TRABAJO_PRACTICO = "trabajo_practico";
	static final public String EVALUACION = "evaluacion";
	static final public Integer PRIMER_TRIMESTRE = 1;
	static final public Integer SEGUNDO_TRIMESTRE = 2;
	static final public Integer TERCER_TRIMESTRE = 3;
	
	@Id
	@GeneratedValue
	@Field(name = "_id")
	private String id;
	
	@Field (name = "nombre")
	private String nombre;
	
	@Field (name = "año")
	private String año;
	
	@Field (name = "trimestre")
	private Integer trimestre;
	
	@Field (name = "descripcion")
	private String descripcion;
	
	@Field (name = "idmateria")
	private String idmateria;
	
	@Field (name = "idalumno")
	private String idalumno;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdmateria() {
		return idmateria;
	}

	public void setIdmateria(String idmateria) {
		this.idmateria = idmateria;
	}

	public String getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(Integer trimestre) {
		this.trimestre = trimestre;
	}

	}
