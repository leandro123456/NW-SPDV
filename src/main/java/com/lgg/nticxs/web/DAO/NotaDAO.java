package com.lgg.nticxs.web.DAO;

import java.util.List;

import javax.persistence.Query;

import com.lgg.nticxs.web.jpa.JPADAO;
import com.lgg.nticxs.web.model.Nota2;

public class NotaDAO extends JPADAO<Nota2>{

	@SuppressWarnings("unchecked")
	public List<Nota2> retrieveAll() {
		String sql = "SELECT u FROM Nota2 u";
		Query query = getEntityManager().createQuery(sql);
		List<Nota2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Nota2 retrieveById(String userId) {
		String sql = "SELECT u FROM Nota2 u WHERE u.id = :id";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("id", userId);
		List<Nota2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Nota2> retrieveByAlumnoMateria(String idalumno, String materia, Integer anio) {
		String sql = "SELECT u FROM Nota2 u WHERE u.idalumno = :idalumno and u.idmateria LIKE :idmateria and  u.fecha LIKE :anio ";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idalumno", idalumno);
		query.setParameter("idmateria", materia);
		query.setParameter("anio", "%" + anio + "%");
		List<Nota2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Nota2> retrieveByAlumnoMateriaTrimestres(String idalumno, String materia, Integer anio) {
		String sql = "SELECT u FROM Nota2 u WHERE u.idalumno = :idalumno and u.idmateria LIKE :idmateria and  u.fecha LIKE :anio and u.tipo = 'trimestral'";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idalumno", idalumno);
		query.setParameter("idmateria", materia);
		query.setParameter("anio", "%" + anio + "%");
		List<Nota2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Nota2> retrieveByAlumno(String idalumno) {
		String sql = "SELECT u FROM Nota2 u WHERE u.idalumno = :idalumno";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idalumno", idalumno);
		List<Nota2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public Nota2 retrieveByNameDateDescription(String idalumno, String fecha, String descripcion) {
		String sql = "SELECT u FROM Nota2 u WHERE u.idalumno LIKE :idalumno and  u.fecha LIKE :fecha and u.descripcion LIKE :descripcion";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idalumno", idalumno);
		query.setParameter("fecha", fecha);
		query.setParameter("descripcion", descripcion);
		List<Nota2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Nota2> retrieveByUserMatter(String user, String matter, Integer anio) {
		String sql = "SELECT u FROM Nota2 u WHERE u.idalumno LIKE :idalumno and  u.idmateria LIKE :idmatter and  u.fecha LIKE :anio ";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idalumno", user);
		query.setParameter("idmatter", matter);
		query.setParameter("anio", "%" + anio + "%");
		List<Nota2> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
}
