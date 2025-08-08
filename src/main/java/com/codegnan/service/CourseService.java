package com.codegnan.service;


import java.util.List;

import com.codegnan.model.CourseDetails;

public interface CourseService {

	public String save(CourseDetails courseDetails);
	
	public List<CourseDetails> findAll();
	
	public CourseDetails findByName(String CourseName);
	
	public String update(CourseDetails courseDetails);
	
	public String deleteByName(String name);

}
