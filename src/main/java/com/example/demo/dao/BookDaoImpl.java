package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

  
    @SuppressWarnings("unchecked")
    public List getAllBook() {
    	List books = getSession().createQuery("from Book").list();
    	
    	System.out.println("Book size "+books.size());
        return books;
    }
}