package com.codegnan.model;



public class StudentsDetails {

	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentsCourses;
	

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentsCourses() {
		return studentsCourses;
	}
	public void setStudentsCourses(String studentsCourses) {
		this.studentsCourses = studentsCourses;
	}
	
	/**
	 * @param studentId
	 * @param studentName
	 * @param studentEmail
	 * @param studentsCourses
	 */
	public StudentsDetails(int studentId, String studentName, String studentEmail, String studentsCourses) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentsCourses = studentsCourses;
	}
	/**
	 * 
	 */
	public StudentsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
