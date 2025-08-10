package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.AssignmentDao;
import com.codegnan.dao.AssignmentDaoImp;
import com.codegnan.model.Assignment;



public class AssignmentServiceImp implements AssignmentService{
	
	
	AssignmentDaoImp assignmentImp = new AssignmentDaoImp();

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
	public List<Assignment> findByStudentId(int studentId) throws ClassNotFoundException {
	    return assignmentImp.getAssignmentsForStudent(studentId);
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
	
	

	public void submitAssignment(int studentId, int assignmentId, String fileName, String filePath) throws ClassNotFoundException {
	    // Combine filename and path for storage
	    String fullPath = filePath.endsWith("/") ? filePath + fileName : filePath + "/" + fileName;
	    assignmentImp.saveSubmission(studentId, assignmentId, fullPath);
	}



}
