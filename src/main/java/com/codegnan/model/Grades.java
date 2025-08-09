package com.codegnan.model;

public class Grades {

	private int gradeId;
	private int submissionId; // FK
	private String grade;
	public Grades() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grades(int gradeId, int submissionId, String grade) {
		super();
		this.gradeId = gradeId;
		this.submissionId = submissionId;
		this.grade = grade;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "GradesDao [gradeId=" + gradeId + ", submissionId=" + submissionId + ", grade=" + grade + "]";
	}

	
}
