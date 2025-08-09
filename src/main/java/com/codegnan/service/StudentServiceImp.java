package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.StudentDaoImp;
import com.codegnan.model.Student;

public class StudentServiceImp implements StudentService{

	StudentDaoImp studentImp = new StudentDaoImp();
	
	@Override
	public String save(Student student) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return studentImp.addStudent(student);
	}

	@Override
	public List<Student> findAll() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return studentImp.getAllStudent();
	}

	@Override
	public Student findById(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return studentImp.getByStudentId(id);
	}

	@Override
	public String update(Student student) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return studentImp.updateByStudentId(student);
	}

	@Override
	public String delete(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return studentImp.deleteByStudentId(id);
	}

}
