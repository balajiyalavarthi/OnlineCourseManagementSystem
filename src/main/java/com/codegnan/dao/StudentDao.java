package com.codegnan.dao;

import java.util.List;


import com.codegnan.model.Student;

public interface StudentDao {
	
	public String addStudent(Student student) throws ClassNotFoundException;
	
	public List<Student> getAllStudent() throws ClassNotFoundException;
	
	public Student getByStudentId(int id) throws ClassNotFoundException;
	
	public String updateByStudentId(Student student) throws ClassNotFoundException;
	
	public String deleteByStudentId(int id) throws ClassNotFoundException;
}
