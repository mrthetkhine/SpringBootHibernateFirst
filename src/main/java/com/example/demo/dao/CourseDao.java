package com.example.demo.dao;

import java.util.List;

import com.example.demo.dao.common.GenericDao;
import com.example.demo.entity.Book;
import com.example.demo.entity.Course;

public interface CourseDao extends GenericDao<Course,Long>{
	
	List<Course> findCourseByName(String name);
	Long getNoOfCourse();
 
}
