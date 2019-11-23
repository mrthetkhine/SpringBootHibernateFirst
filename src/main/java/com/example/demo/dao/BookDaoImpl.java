package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.common.GenericDaoImpl;
import com.example.demo.entity.Book;

@Repository
@Transactional
public class BookDaoImpl extends GenericDaoImpl<Book, Long> implements BookDao {
    /*
	@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    */

  
    @SuppressWarnings("unchecked")
    public List getAllBook() {
    	List books = this.getCurrentSession().createQuery("from Book").list();
    	
    	System.out.println("Book size "+books.size());
        return books;
    }

	@Override
	public List<Book> findBookByTitle(String title) {
		String hql = "from Book where title = :title";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter("title", title);
		
		return query.list();
	}
}