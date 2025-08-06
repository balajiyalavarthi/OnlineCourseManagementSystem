package com.codegnan.model;

public class InstructorDetails {
	
	private int instructorId;
	private String instructorName;
	private String instructorEmail;
	private String instructorCourse;
	
	
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getInstructorEmail() {
		return instructorEmail;
	}
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	public String getInstructorCourse() {
		return instructorCourse;
	}
	public void setInstructorCourse(String instructorCourse) {
		this.instructorCourse = instructorCourse;
	}
	/**
	 * @param instructorId
	 * @param instructorName
	 * @param instructorEmail
	 * @param instructorCourse
	 */
	public InstructorDetails(int instructorId, String instructorName, String instructorEmail, String instructorCourse) {
		super();
		this.instructorId = instructorId;
		this.instructorName = instructorName;
		this.instructorEmail = instructorEmail;
		this.instructorCourse = instructorCourse;
	}
	/**
	 * 
	 */
	public InstructorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


}
