package com.techm.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;
	
	public <T> Serializable create(final T entity){
		return sessionFactory.getCurrentSession().save(entity);
	}
	
	public <T> T update(final T entity){
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}
	
	public <T> void delete(final T entity){
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public <T> void delete(Serializable id, Class<T> entityClass){
		T entity= fetchById(id, entityClass);
		delete(entity);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public <T> List<T> fetchAll(Class <T> entityClass){
		System.out.println(entityClass.getName());
		return sessionFactory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list();        
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public <T> List<T> fetchAll(String query){
		return sessionFactory.getCurrentSession().createSQLQuery(query).list();
	}
	
	public <T> T fetchById(Serializable id, Class<T> entityClass) {
		return (T)sessionFactory.getCurrentSession().get(entityClass, id);
	}
}
