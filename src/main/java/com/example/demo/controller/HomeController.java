package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.BookDaoImpl;
import com.example.demo.dao.CourseDao;
import com.example.demo.dto.BookDto;

import java.util.*;
import com.example.demo.entity.*;
@Controller	
public class HomeController {
	
	@Autowired
	BookDao bookDao;
	
	
	
	@GetMapping("/")
	public String home(Model model)
	{
		System.out.println("Controller Home");
		List<Book> books = (List<Book>) this.bookDao.findBookByDescription("bla");
		System.out.println("Book size "+books.size());
		for(Book b : books)
		{
			System.out.println("Book "+b.getTitle());
		}
		
		int result = this.bookDao.updateBookTitle(1L, "JavaSE");
		System.out.println("Result after update "+result);
		Book java = this.bookDao.getByIdWithNameQuery(1L);
		
		System.out.println("Book >>"+java.getTitle() + " Detail "+java.getBookDetail().getContent());
		model.addAttribute("java", java);
		
		System.out.println("Book count "+this.bookDao.getTotalBook());
		
		List<BookDto> booksDto = this.bookDao.getAllTitle();
		for(BookDto dto : booksDto)
		{
			System.out.println("Book title "+dto.getTitle());
		}
		return "home";
	}
}
