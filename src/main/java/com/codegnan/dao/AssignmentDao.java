package com.codegnan.dao;

import java.util.List;

import com.codegnan.model.Assignment;

public interface AssignmentDao {

	public String addAssignment(Assignment assignment) throws ClassNotFoundException;

	public List<Assignment> getAllAssignment() throws ClassNotFoundException;

	public Assignment getByAssignmentId(int assignmentId) throws ClassNotFoundException;

	public String updateByAssignmentId(Assignment assignment) throws ClassNotFoundException;

	public String deleteByAssignmentId(int assignmentId) throws ClassNotFoundException;

}
