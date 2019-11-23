package com.example.demo.dao.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface GenericDao<T, Key extends Serializable> 
{
	Session getCurrentSession() throws HibernateException;
	
	List<T> getAll() throws HibernateException;
	
	public T get(Key id) throws HibernateException;
	
	Long saveWithId(T entity) throws HibernateException;
	
	void save(T entity) throws HibernateException;
	
	void saveOrUpdate(T entity) throws HibernateException;
	
	void update(T entity) throws HibernateException;
	
	void merge(T entity) throws HibernateException;
	
	void deleteById(long uniqueId) throws HibernateException;
	
	void delete(T entity) throws HibernateException;
	
	void addAll(Collection<T> entityList) throws HibernateException;
	
	void saveOrUpdateAll(Collection<T> entityList) throws HibernateException;
	
	public List<T> hqlExecuteQuery(String queryString, Map<String, Object> singleValueParamMap,
			Map<String, Object[]> listValueParamMap) throws HibernateException;
	
	public int hqlExecuteUpdate(String queryString, Map<String, Object> singleValueParamMap,
			Map<String, Object[]> listValueParamMap) throws HibernateException;

	void persist(T entity);

	void saveAndFlush(T entity);
}


