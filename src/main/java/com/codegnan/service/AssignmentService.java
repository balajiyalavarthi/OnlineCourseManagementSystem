package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Assignment;

public interface AssignmentService {
	
	public String save(Assignment assignment) throws ClassNotFoundException;

	public List<Assignment> findAll() throws ClassNotFoundException;

	public Assignment findById(int assignmentId) throws ClassNotFoundException;

	public String update(Assignment assignment) throws ClassNotFoundException;

	public String delete(int assignmentId) throws ClassNotFoundException;
}
