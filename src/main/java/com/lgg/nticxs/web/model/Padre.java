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
public class Padre {
	
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
	
	@Field (name = "keyTSA")
	private String keyTSA;
	
	@Field (name = "role")
	private String role;
	
	@Field (name = "listLots")
	private ListLotsUser listLots;
	
	@Field (name = "listCardLots")
	private ListCardLotsUser listCardLots;
	
	@Field (name = "delete")
	private Boolean delete;
	
	@ElementCollection
	@Field(name="notas")
	private List<Nota> notas;
	
	@ElementCollection
	@Field(name="mensajes")
	private List<Mensaje> mensajes;

	@ElementCollection
	@Field(name="asistencia")
	private List<Asistencia> asistencia;

	
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

	public String getKeyTSA() {
		return keyTSA;
	}

	public void setKeyTSA(String keyTSA) {
		this.keyTSA = keyTSA;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ListLotsUser getListLots() {
		return listLots;
	}

	public void setListLots(ListLotsUser listLots) {
		this.listLots = listLots;
	}

	public ListCardLotsUser getListCardLots() {
		return listCardLots;
	}

	public void setListCardLots(ListCardLotsUser listCardLots) {
		this.listCardLots = listCardLots;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}
}
