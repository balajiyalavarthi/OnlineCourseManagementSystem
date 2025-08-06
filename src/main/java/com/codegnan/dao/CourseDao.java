package com.codegnan.dao;

import java.util.List;

import com.codegnan.model.CourseDetails;

public interface CourseDao {

	public String addCourse(CourseDetails courseDetails);
	
	public List<CourseDetails> getAllCourses();
	
	public CourseDetails getByCourseName(String CourseName);
	
	public String updateCourse(CourseDetails courseDetails);
	
	public String deleteCourseByName(String name);
}
