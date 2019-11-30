package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.common.GenericDaoImpl;
import com.example.demo.entity.Book;
import com.example.demo.entity.Course;

@Repository
@Transactional
public class CourseDaoImpl extends GenericDaoImpl<Course, Long> implements CourseDao{

	@Override
	public List<Course> findCourseByName(String name) {
		Criteria c = this.getCurrentSession()
					.createCriteria(Course.class);
					
		return c.list();
	}

}
