package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.InstructorDao;
import com.codegnan.dao.InstructorDaoImp;
import com.codegnan.model.Instructor;

public class InstructorServiceImp implements InstructorService{
	
	InstructorDao instructorImp = new InstructorDaoImp();
	
	@Override
	public String save(Instructor instructor) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return instructorImp.addInstructor(instructor);
	}

	@Override
	public List<Instructor> findAll() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return instructorImp.getAllInstructors();
	}

	@Override
	public Instructor findById(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return instructorImp.getByInstructorId(id);
	}

	@Override
	public String update(Instructor instructor) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return instructorImp.updateByInstructorId(instructor);
	}

	@Override
	public String deleted(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return instructorImp.deleteByInstructorId(id);
	}
	


}
