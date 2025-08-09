package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.SubmissionDaoImp;
import com.codegnan.model.Submission;

public class SubmissionServiceImp implements SubmissionService{
	
	SubmissionDaoImp submissionImp = new SubmissionDaoImp();

	@Override
	public String save(Submission submission) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return submissionImp.addSubmission(submission);
	}

	@Override
	public List<Submission> findAll() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return submissionImp.getAllSubmission();
	}

	@Override
	public Submission findById(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return submissionImp.getBySubmissionId(id);
	}

	@Override
	public String update(Submission submission) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return submissionImp.updateBySubmissionId(submission);
	}

	@Override
	public String delete(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return submissionImp.deleteBySubmissionId(id);
	}

}
