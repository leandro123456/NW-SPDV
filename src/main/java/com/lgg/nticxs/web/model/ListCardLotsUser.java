package com.lgg.nticxs.web.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class ListCardLotsUser {
	
	@ElementCollection
	@Field(name = "listView")
	private List<String> listLotsCardsEdit;
	
	@ElementCollection
	@Field(name = "listEdit")
	private List<String> listLotsCardsView;
	
	
	public List<String> getListLotsCardsEdit() {
		return listLotsCardsEdit;
	}
	
	public void setListLotsCardsEdit(List<String> listLotsCardsEdit) {
		this.listLotsCardsEdit = listLotsCardsEdit;
	}
	
	public List<String> getListLotsCardsView() {
		return listLotsCardsView;
	}
	
	public void setListLotsCardsView(List<String> listLotsCardsView) {
		this.listLotsCardsView = listLotsCardsView;
	}
}
