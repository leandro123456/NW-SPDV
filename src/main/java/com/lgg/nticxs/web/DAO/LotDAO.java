package com.lgg.nticxs.web.DAO;

import java.util.List;

import javax.persistence.Query;

import com.lgg.nticxs.web.jpa.JPADAO;
import com.lgg.nticxs.web.model.Lot;

public class LotDAO extends JPADAO<Lot> {
	
	@SuppressWarnings("unchecked")
	public List<Lot> retrieveAll() {
		String sql = "SELECT l FROM Lot l";
		Query query = getEntityManager().createQuery(sql);
		List<Lot> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Lot retrieveByNameLote(String nameLote) {
		String sql = "SELECT l FROM Lot l WHERE l.nameOfLote = :nameLote";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("nameLote", nameLote);
		List<Lot> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
