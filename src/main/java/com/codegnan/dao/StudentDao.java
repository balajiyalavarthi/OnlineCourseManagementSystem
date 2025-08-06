package com.codegnan.dao;

import java.util.List;

import com.codegnan.model.StudentsDetails;



public interface StudentDao {
	
public String addStudent(StudentsDetails studentsDetails);
	
	public List<StudentsDetails> getAllStudents();
	
	public StudentsDetails getByStudentName(String studentName);
	
	public String updateStudent(StudentsDetails studentDetails);
	
	public String deleteStudentByName(String name);
}
