package com.example.demo.dao;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.common.GenericDaoImpl;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.sqlconstant.SqlConstant;

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

	@Override
	public Book getById(Long id) {
		// TODO Auto-generated method stub
		String hql = "select b from Book b LEFT JOIN FETCH b.bookDetail bd where b.id = :id";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setLong("id", id);
		Book book = (Book) query.uniqueResult();
		//book.getBookDetail();
		return book;
	}

	@Override
	public Book getByIdWithNameQuery(Long id) {
		// TODO Auto-generated method stub
		Query query = this.getCurrentSession()
						.createNamedQuery(SqlConstant.GET_BOOK_BY_ID, Book.class);
		query.setLong("id", id);
		Book book = (Book) query.uniqueResult();
		//book.getBookDetail();
		return book;
	}
	@Override
	public int getTotalBook()
	{
		Query query = this.getCurrentSession()
				.createNamedQuery(SqlConstant.GET_BOOK_COUNT);
		
		List<Object> result = query.getResultList();
		return ((BigInteger)result.get(0)).intValue();
		
		
	}
	@Override
	public List<BookDto> getAllTitle()
	{
		List<BookDto> bookDtos= this.getCurrentSession()
				.createNativeQuery("SELECT title  from book")
				.setResultTransformer( Transformers.aliasToBean( BookDto.class ) )
				.list();
		
		return bookDtos;
	}
}