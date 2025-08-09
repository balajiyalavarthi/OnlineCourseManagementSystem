package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Student;

public interface StudentService {

	public String save(Student student) throws ClassNotFoundException;
	
	public List<Student> findAll() throws ClassNotFoundException;
	
	public Student findById(int id) throws ClassNotFoundException;
	
	public String update(Student student) throws ClassNotFoundException;
	
	public String delete(int id) throws ClassNotFoundException;
}
