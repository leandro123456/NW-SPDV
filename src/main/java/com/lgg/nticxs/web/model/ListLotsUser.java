package com.lgg.nticxs.web.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class ListLotsUser {
	
	@ElementCollection
	@Field(name = "listView")
	private List<String> listView;
	
	@ElementCollection
	@Field(name = "listEdit")
	private List<String> listEdit;
	
	public List<String> getListView() {
		return listView;
	}
	
	public void setListView(List<String> listView) {
		this.listView = listView;
	}
	
	public List<String> getListEdit() {
		return listEdit;
	}
	
	public void setListEdit(List<String> listEdit) {
		this.listEdit = listEdit;
	}
}
