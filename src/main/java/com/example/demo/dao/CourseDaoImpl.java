package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.common.GenericDaoImpl;
import com.example.demo.entity.Book;
import com.example.demo.entity.Course;

@Repository
@Transactional
public class CourseDaoImpl extends GenericDaoImpl<Course, Long> implements CourseDao{

	@Override
	public List<Course> findCourseByName(String name) {
		System.out.println("Find course by name");
		Criteria c = this.getCurrentSession()
					.createCriteria(Course.class)
					.createAlias("users", "users",JoinType.LEFT_OUTER_JOIN)
					.add(Restrictions.or(
							Restrictions.like("name", name, MatchMode.ANYWHERE),
							Restrictions.like("description", name, MatchMode.ANYWHERE)
							)
						)
					
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
					
					
		return c.list();
	}

}
