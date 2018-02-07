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
public class Alumno{
	static final public String ROLE_ALUMNO = "ALUMNO";

	@Id
	@GeneratedValue
	@Field(name = "_id")
	private String id;
	
	@Field (name = "name")
	private String name;
	
	@Field (name = "password")
	private byte[] password;
	
	@Field (name = "historyPassword")
	private List<byte[]> historyPassword;
	
	@Field (name = "delete")
	private Boolean delete;

	@Field (name = "role")
	private String role;
	
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
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public byte[] getPassword() {
		return password;
	}


	public void setPassword(byte[] password) {
		this.password = password;
	}


	public List<byte[]> getHistoryPassword() {
		return historyPassword;
	}


	public void setHistoryPassword(List<byte[]> historyPassword) {
		this.historyPassword = historyPassword;
	}


	public Boolean getDelete() {
		return delete;
	}


	public void setDelete(Boolean delete) {
		this.delete = delete;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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
