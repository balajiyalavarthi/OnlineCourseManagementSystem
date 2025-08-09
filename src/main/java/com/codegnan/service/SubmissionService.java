package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Submission;

public interface SubmissionService {
	
	   public String save(Submission submission) throws ClassNotFoundException;

	   public List<Submission> findAll() throws ClassNotFoundException;

	   public Submission findById(int id) throws ClassNotFoundException;

	   public String update(Submission submission) throws ClassNotFoundException;

	   public String delete(int id) throws ClassNotFoundException;

}
