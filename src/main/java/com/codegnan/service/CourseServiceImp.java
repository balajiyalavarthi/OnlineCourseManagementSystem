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
	public Course findById(int courseId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return courseImp.getByCourseId(courseId);
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

	public List<Course> findCoursesByInstructor(int instructorId) throws ClassNotFoundException {
	    return courseImp.findCoursesByInstructor(instructorId);
	}
	
}
