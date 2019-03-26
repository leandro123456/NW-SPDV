package com.lgg.nticxs.web.DAO;

import java.util.List;

import javax.persistence.Query;

import com.lgg.nticxs.web.jpa.JPADAO;
import com.lgg.nticxs.web.model.Asistencia2;

public class AsistenciaDAO extends JPADAO<Asistencia2>{

	@SuppressWarnings("unchecked")
	public List<Asistencia2> retrieveAll() {
		String sql = "SELECT u FROM Asistencia2 u";
		Query query = getEntityManager().createQuery(sql);
		List<Asistencia2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Asistencia2> retrieveByAlumno(String idalumno) {
		String sql = "SELECT u FROM Asistencia2 u WHERE u.idalumno = :idalumno";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idalumno", idalumno);
		List<Asistencia2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public Asistencia2 retrieveByNameDateDescription(String idalumno, String fecha) {
		String sql = "SELECT u FROM Asistencia2 u WHERE u.idalumno LIKE :idalumno and  u.fecha LIKE :fecha";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idalumno", idalumno);
		query.setParameter("fecha", fecha);
		List<Asistencia2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Asistencia2> retrieveByUserMatter(String idalumno, String materia, Integer anioActual) {
		String sql = "SELECT u FROM Asistencia2 u WHERE u.idalumno LIKE :idalumno and  u.idmateria LIKE :idmatter and  u.fecha LIKE :anio ";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idalumno", idalumno);
		query.setParameter("idmatter", materia);
		query.setParameter("anio", "%" + anioActual + "%");
		List<Asistencia2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
}
