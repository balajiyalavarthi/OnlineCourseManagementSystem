package com.codegnan.service;

import java.util.List;

import com.codegnan.model.InstructorDetails;

public interface InstructorService {

	public String save(InstructorDetails instructorDetails);
	
	public List<InstructorDetails> finAll();
	
	public InstructorDetails findById(int instructorId);
	
	public String update(InstructorDetails instructorDetails);
	
	public String deleteById(int instructorId);
}
