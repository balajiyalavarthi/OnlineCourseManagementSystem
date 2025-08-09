package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.CourseDaoImp;
import com.codegnan.model.Course;

public class CourseServiceImp implements CourseService{

	CourseDaoImp courseImp = new CourseDaoImp();
	
	@Override
	public String save(Course course) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return courseImp.addCourse(course);
	}

	@Override
	public List<Course> findAll() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return courseImp.getAllCourses();
	}

	@Override
	public Course findById(String courseName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return courseImp.getByCourseName(courseName);
	}

	@Override
	public String update(Course course) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return courseImp.updateByCourseName(course);
	}

	@Override
	public String delete(String courseName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return courseImp.deleteByCourseName(courseName);
	}

	
}
