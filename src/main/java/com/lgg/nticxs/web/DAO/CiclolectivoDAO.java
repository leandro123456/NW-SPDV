package com.lgg.nticxs.web.DAO;

import java.util.List;

import javax.persistence.Query;

import com.lgg.nticxs.web.jpa.JPADAO;
import com.lgg.nticxs.web.model.Alumno;

public class CiclolectivoDAO extends JPADAO<CiclolectivoDAO>{

	@SuppressWarnings("unchecked")
	public List<CiclolectivoDAO> retrieveAll() {
		String sql = "SELECT u FROM Ciclolectivo u";
		Query query = getEntityManager().createQuery(sql);
		List<CiclolectivoDAO> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public CiclolectivoDAO retrieveByAño(String anio) {
		String sql = "SELECT u FROM Ciclolectivo u WHERE u.anio = :anio";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("anio", anio);
		List<CiclolectivoDAO> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
