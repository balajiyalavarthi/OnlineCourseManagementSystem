package com.codegnan.dao;

import java.util.List;


import com.codegnan.model.Instructor;

public interface InstructorDao {
	
	
	public String addInstructor(Instructor instructor) throws ClassNotFoundException;
	
	public List<Instructor> getAllInstructors() throws ClassNotFoundException;
	
	public Instructor getByInstructorId(int id) throws ClassNotFoundException;
	
	public String updateByInstructorId(Instructor instructor) throws ClassNotFoundException;
	
	public String deleteByInstructorId(int id) throws ClassNotFoundException;
}
