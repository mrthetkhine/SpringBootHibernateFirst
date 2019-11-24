package com.example.demo.dao;

import java.util.List;

import com.example.demo.dao.common.GenericDao;
import com.example.demo.entity.Book;

public interface BookDao extends GenericDao<Book,Long>{
	public List getAllBook() ;
	
	List<Book> findBookByTitle(String title);
	Book getById(Long id);
}
