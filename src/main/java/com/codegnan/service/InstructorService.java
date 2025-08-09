package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Instructor;

public interface InstructorService {

	public String save(Instructor instructor) throws ClassNotFoundException;
	
	public List<Instructor> findAll() throws ClassNotFoundException;
	
	public Instructor findById(int id) throws ClassNotFoundException;
	
	public String update(Instructor instructor) throws ClassNotFoundException;
	
	public String deleted(int id) throws ClassNotFoundException;

}
