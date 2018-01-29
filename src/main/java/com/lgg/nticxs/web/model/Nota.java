package com.lgg.nticxs.web.model;

import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;


@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Nota {
	
	@GeneratedValue
	@Field(name = "_id")
	private String id;
	
	@Field (name = "tipo")
	private String tipo;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Field (name = "valor")
	private Integer valor;
	
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

	}
