package com.lgg.nticxs.web.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Alumno extends User{
	
	@ElementCollection
	@Field(name="notas")
	private List<Nota> notas;
	
	@ElementCollection
	@Field(name="mensajes")
	private List<Mensaje> mensajes;

	@ElementCollection
	@Field(name="asistencia")
	private List<Asistencia> asistencia;

	@Field (name = "cuenta_iniciada")
	private Boolean cuenta_iniciada;
	
	public Alumno(){
		this.setRole(ROLE_ALUMNO);
		cuenta_iniciada=false;
	}
	
	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public List<Asistencia> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(List<Asistencia> asistencia) {
		this.asistencia = asistencia;
	}

	public Boolean getCuenta_iniciada() {
		return cuenta_iniciada;
	}

	public void setCuenta_iniciada(Boolean cuenta_iniciada) {
		this.cuenta_iniciada = cuenta_iniciada;
	}
	
	
	
}
