package com.lgg.nticxs.web.DAO;

import java.util.List;

import javax.persistence.Query;

import com.lgg.nticxs.web.jpa.JPADAO;
import com.lgg.nticxs.web.model.SimpleMateria;

public class SimpleMateriaDAO extends JPADAO<SimpleMateria>{

	@SuppressWarnings("unchecked")
	public List<SimpleMateria> retrieveAll() {
		String sql = "SELECT u FROM SimpleMateria u";
		Query query = getEntityManager().createQuery(sql);
		List<SimpleMateria> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public SimpleMateria retrieveById(String userId) {
		String sql = "SELECT u FROM SimpleMateria u WHERE u.id = :id";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("id", userId);
		List<SimpleMateria> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public SimpleMateria retrieveByIdMateria(String idmateria) {
		String sql = "SELECT u FROM SimpleMateria u WHERE u.materia = :idmateria";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idmateria", idmateria);
		List<SimpleMateria> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
//
//	public SimpleMateria retrieveByNameDateDescription(String idalumno, String fecha, String descripcion) {
//		String sql = "SELECT u FROM Nota u WHERE u.idalumno LIKE :idalumno and  u.fecha LIKE :fecha and u.descripcion LIKE :descripcion";
//		Query query = getEntityManager().createQuery(sql);
//		query.setParameter("idalumno", idalumno);
//		query.setParameter("fecha", fecha);
//		query.setParameter("descripcion", descripcion);
//		List<SimpleMateria> list = query.getResultList();
//		if (list != null && list.size() > 0) {
//			return list.get(0);
//		}
//		return null;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public SimpleMateria retrieveByUserMatter(String user, String matter, Integer anio) {
//		String sql = "SELECT u FROM Nota u WHERE u.idalumno LIKE :idalumno and  u.idmateria LIKE :idmatter and  u.fecha LIKE :anio ";
//		Query query = getEntityManager().createQuery(sql);
//		query.setParameter("idalumno", user);
//		query.setParameter("idmatter", matter);
//		query.setParameter("anio", ""+anio);
//		List<SimpleMateria> list = query.getResultList();
//		if (list != null && list.size() > 0) {
//			return list.get(0);
//		}
//		return null;
//	}
}
