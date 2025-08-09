package com.codegnan.dao;

import java.util.List;

import com.codegnan.model.Course;

public interface CourseDao {

	public String addCourse(Course course) throws ClassNotFoundException;
	
	public List<Course> getAllCourses() throws ClassNotFoundException;
	
	public Course getByCourseName(String courseName) throws ClassNotFoundException;
	
	public String updateByCourseName(Course course) throws ClassNotFoundException;
	
	public String deleteByCourseName(String courseName) throws ClassNotFoundException;


	
	
}
