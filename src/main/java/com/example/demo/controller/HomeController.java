package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.BookDaoImpl;
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
		List<Book> books = (List<Book>) this.bookDao.findBookByTitle("Java");
		System.out.println("Book size "+books.size());
		for(Book b : books)
		{
			System.out.println("Book "+b.getTitle());
		}
		
		Book java = this.bookDao.getByIdWithNameQuery(1L);
		
		System.out.println("Book >>"+java.getTitle() + " Detail "+java.getBookDetail().getContent());
		model.addAttribute("java", java);
		
		System.out.println("Book count "+this.bookDao.getTotalBook());
		return "home";
	}
}
