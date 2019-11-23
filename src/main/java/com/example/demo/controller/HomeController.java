package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookDao;
import java.util.*;
import com.example.demo.entity.*;
@Controller	
public class HomeController {
	
	@Autowired
	BookDao bookDao;
	
	@GetMapping("/")
	public String home()
	{
		System.out.println("Controller Home");
		List<Book> books = (List<Book>) this.bookDao.getAllBook();
		for(Book b : books)
		{
			System.out.println("Book "+b.getTile());
		}
		return "home";
	}
}
