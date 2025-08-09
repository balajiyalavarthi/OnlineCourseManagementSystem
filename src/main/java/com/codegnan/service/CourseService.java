package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Course;

public interface CourseService {
	
	public String save(Course course) throws ClassNotFoundException;
	
	public List<Course> findAll() throws ClassNotFoundException;
	
	public Course findById(String courseName) throws ClassNotFoundException;
	
	public String update(Course course) throws ClassNotFoundException;
	
	public String delete(String courseName) throws ClassNotFoundException;


}
