package com.codegnan.dao;

import java.util.List;
import com.codegnan.model.Submission;

public interface SubmissionDao {

   public String addSubmission(Submission submission) throws ClassNotFoundException;

   public List<Submission> getAllSubmission() throws ClassNotFoundException;

   public Submission getBySubmissionId(int id) throws ClassNotFoundException;

   public String updateBySubmissionId(Submission submission) throws ClassNotFoundException;

   public String deleteBySubmissionId(int id) throws ClassNotFoundException;
}
