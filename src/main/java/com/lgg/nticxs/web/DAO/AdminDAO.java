package com.lgg.nticxs.web.DAO;

import java.util.List;

import javax.persistence.Query;

//import org.eclipse.persistence.config.HintValues;
//import org.eclipse.persistence.config.QueryHints;

import com.lgg.nticxs.web.jpa.JPADAO;
import com.lgg.nticxs.web.model.User;

public class AdminDAO extends JPADAO<User>{
//	@SuppressWarnings("unchecked")
//	public List<User> retrieve(){
//		String sql = "SELECT u FROM User u";
//		Query query = getEntityManager().createQuery(sql);
//		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
//		return query.getResultList();
//	}

	@SuppressWarnings("unchecked")
	public List<User> retrieveAll() {
		String sql = "SELECT u FROM User u WHERE u.delete=false";
		Query query = getEntityManager().createQuery(sql);
		List<User> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public User retrieveById(String userId) {
		String sql = "SELECT u FROM User u WHERE u.id = :id";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("id", userId);
		List<User> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public User retrieveByName(String name) {
		String sql = "SELECT u FROM User u WHERE u.name = :name and u.delete=false";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("name", name);
		List<User> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
    public void deleteUser(String id) {
		String sql = "SELECT u FROM User u WHERE u.id = :id";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("id", id);
		List<User> list = query.getResultList();
		list.get(0).setDelete(true);
		update(list.get(0));
	}
}