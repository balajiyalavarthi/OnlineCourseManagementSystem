package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.InstructorDao;
import com.codegnan.dao.InstructorDaoImp;
import com.codegnan.model.InstructorDetails;


public class InstructorServiceImp implements InstructorService{
	
	InstructorDao instructor = new InstructorDaoImp();

	@Override
	public String save(InstructorDetails instructorDetails) {
		
		return instructor.addInstructor(instructorDetails);
	}

	@Override
	public List<InstructorDetails> finAll() {
		
		return instructor.getAllInstructors();
	}

	@Override
	public InstructorDetails findById(int instructorId) {
		
		return instructor.getByInstructorId(instructorId);
	}

	@Override
	public String update(InstructorDetails instructorDetails) {
		
		return instructor.updateInstructor(instructorDetails);
	}

	@Override
	public String deleteById(int instructorId) {
		
		return instructor.deleteInstructorById(instructorId);
	}

}
