package com.codegnan.model;

import java.sql.Date;

public class Submission {

	private int submissionId;
    private int assignmentId; // FK
    private int studentId;    // FK
    private String filePath;
    private Date submittedOn;
    
    
	public int getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}
	public int getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getSubmittedOn() {
		return submittedOn;
	}
	public void setSubmittedOn(Date submittedOn) {
		this.submittedOn = submittedOn;
	}
	
	
	public Submission(int submissionId, int assignmentId, int studentId, String filePath, Date submittedOn) {
		super();
		this.submissionId = submissionId;
		this.assignmentId = assignmentId;
		this.studentId = studentId;
		this.filePath = filePath;
		this.submittedOn = submittedOn;
	}
	
	public Submission() {
		super();
	}
	
	@Override
	public String toString() {
		return "SubmissionDao [submissionId=" + submissionId + ", assignmentId=" + assignmentId + ", studentId="
				+ studentId + ", filePath=" + filePath + ", submittedOn=" + submittedOn + "]";
	}
    
    
}
