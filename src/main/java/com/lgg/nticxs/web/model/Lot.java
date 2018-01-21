package com.lgg.nticxs.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Lot {
	
	@Id
	@GeneratedValue
	@Field(name = "_id")
	private String id;
	
	@Field(name = "nameOfLote")
	private String nameOfLote;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameOfLote() {
		return nameOfLote;
	}

	public void setNameOfLote(String nameOfLote) {
		this.nameOfLote = nameOfLote;
	}

}
