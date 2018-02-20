package com.lgg.nticxs.web.model;

import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

	
	

@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Nota {
	static final public String ACTIVIDADES = "actividad";
	static final public String TRABAJO_PRACTICO = "trabajo_practico";
	static final public String EVALUACION = "evaluacion";
	static final public Integer PRIMER_TRIMESTRE = 1;
	static final public Integer SEGUNDO_TRIMESTRE = 2;
	static final public Integer TERCER_TRIMESTRE = 3;
	
	
	@Field(name = "_id")
	private String id;
	
	@Field (name = "tipo")
	private String tipo;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Field (name = "valor")
	private Integer valor;
	
	@Field (name = "trimestre")
	private Integer trimestre;
	
	@Field (name = "descripcion")
	private String descripcion;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
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
