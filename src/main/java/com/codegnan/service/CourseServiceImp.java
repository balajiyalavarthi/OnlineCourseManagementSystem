package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.CourseDao;
import com.codegnan.dao.CourseDaoImp;
import com.codegnan.model.CourseDetails;

public class CourseServiceImp implements CourseService{
	
	CourseDao course = new CourseDaoImp();

	@Override
	public String save(CourseDetails courseDetails) {
		
		return course.addCourse(courseDetails);
	}

	@Override
	public List<CourseDetails> findAll() {
		
		return course.getAllCourses();
	}

	@Override
	public CourseDetails findByName(String CourseName) {
		
		return course.getByCourseName(CourseName);
	}

	@Override
	public String update(CourseDetails courseDetails) {
		
		return course.updateCourse(courseDetails);
	}

	@Override
	public String deleteByName(String name) {
		
		return course.deleteCourseByName(name);
	}


}
