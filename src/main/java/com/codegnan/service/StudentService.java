package com.codegnan.service;


import java.util.List;

import com.codegnan.model.StudentsDetails;

public interface StudentService{
	
	public String save(StudentsDetails studentsDetails);
	
	public List<StudentsDetails> findAll();
	
	public StudentsDetails findById(int studentId);
	
	public String update(StudentsDetails studentDetails);
	
	public String deleteById(int studentId);

}
