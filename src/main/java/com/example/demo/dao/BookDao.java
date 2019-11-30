package com.example.demo.dao;

import java.util.List;

import com.example.demo.dao.common.GenericDao;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;

public interface BookDao extends GenericDao<Book,Long>{
	public List getAllBook() ;
	
	List<Book> findBookByTitle(String title);
	Book getById(Long id);
	Book getByIdWithNameQuery(Long id);
	int getTotalBook();
	List<BookDto> getAllTitle();
	int updateBookTitle(Long id, String title);
	
	List<Book> findBookByDescription(String des);
}
