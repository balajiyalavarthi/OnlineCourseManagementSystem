package com.codegnan.dao;

import java.util.List;

import com.codegnan.model.StudentsDetails;



public interface StudentDao {
	
public String addStudent(StudentsDetails studentsDetails);
	
	public List<StudentsDetails> getAllStudents();
	
	public StudentsDetails getByStudentId(int studentId);
	
	public String updateStudent(StudentsDetails studentDetails);
	
	public String deleteStudentById(int studentId);
}
