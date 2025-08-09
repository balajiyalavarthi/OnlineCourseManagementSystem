package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.AssignmentDao;
import com.codegnan.dao.AssignmentDaoImp;
import com.codegnan.model.Assignment;



public class AssignmentServiceImp implements AssignmentService{
	
	
	AssignmentDao assignmentImp = new AssignmentDaoImp()

	@Override
	public String save(Assignment assignment) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return assignmentImp.addAssignment(assignment);
	}

	@Override
	public List<Assignment> findAll() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return assignmentImp.getAllAssignment();
	}

	@Override
	public Assignment findById(int assignmentId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return assignmentImp.getByAssignmentId(assignmentId);
	}

	@Override
	public String update(Assignment assignment) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return assignmentImp.updateByAssignmentId(assignment);
	}

	@Override
	public String delete(int assignmentId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return assignmentImp.deleteByAssignmentId(assignmentId);
	}

}
