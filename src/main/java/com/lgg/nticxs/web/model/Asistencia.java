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
public class Asistencia {

	static final public Integer PRSENTE = 0;
	static final public Integer AUSENTE = 1;
	static final public Integer AUSENTE_JUSTIFICADO = 2;
	
	@Field(name = "_id")
	private String id;
	
	@Field (name = "tipo")
	private Integer tipo;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Field (name = "descripcion")
	private String descripcion;
	
	@Field (name = "materia")
	private String materia;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

		public String getDescripcion() {
		return descripcion;
	}

	public String getMateria() {
			return materia;
		}

		public void setMateria(String materia) {
			this.materia = materia;
		}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
