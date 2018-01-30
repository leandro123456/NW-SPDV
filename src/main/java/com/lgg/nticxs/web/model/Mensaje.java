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
public class Mensaje {
	
	@Field(name = "_id")
	private String id;
	
	@Field (name = "tipo")
	private String tipo;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Field (name = "contenido")
	private String contenido;
	
	@Field (name = "encabezado")
	private String encabezado;
	
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

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}


	}
