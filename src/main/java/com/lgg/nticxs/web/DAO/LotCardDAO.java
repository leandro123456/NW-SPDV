package com.lgg.nticxs.web.DAO;

import java.util.List;

import javax.persistence.Query;

import com.lgg.nticxs.web.jpa.JPADAO;
import com.lgg.nticxs.web.model.LotCard;

public class LotCardDAO extends JPADAO<LotCard> {
	
	@SuppressWarnings("unchecked")
	public List<LotCard> retrieveAll() {
		String sql = "SELECT l FROM LotCard l";
		Query query = getEntityManager().createQuery(sql);
		List<LotCard> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public LotCard retrieveByNameLotCard(String nameLot) {
		String sql = "SELECT l FROM LotCard l WHERE l.nameLot = :nameLot";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("nameLot", nameLot);
		List<LotCard> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
