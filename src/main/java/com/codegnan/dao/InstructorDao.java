package com.codegnan.dao;

import java.util.List;

import com.codegnan.model.InstructorDetails;



public interface InstructorDao {
	
	public String addInstructor(InstructorDetails instructorDetails);
	
	public List<InstructorDetails> getAllInstructors();
	
	public InstructorDetails getByInstructorName(String instructorName);
	
	public String updateInstructor(InstructorDetails instructorDetails);
	
	public String deleteInstructorByName(String name);
}

