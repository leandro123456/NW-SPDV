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

	static final public String PRSENTE = "Presente";
	static final public String AUSENTE = "Ausente";
	static final public String AUSENTE_JUSTIFICADO = "Ausente_Justificado";
	
	@Field(name = "_id")
	private String id;
	
	@Field (name = "tipo")
	private String tipo;
	
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
