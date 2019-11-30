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
public class CourseController {
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	CourseDao courseDao;
	
	@GetMapping("/course")
	public String course(Model model)
	{
		System.out.println("Controller course");
		List<Course> courses = this.courseDao.findCourseByName("course");
		model.addAttribute("courses", courses);
		return "courses";
	}
	
}
