package com.codegnan.model;

import java.util.List;



public class CourseDetails {

	private long courseId;
	private String courseName;
	private String courseDiscription;
	private double coursePrice;
	private String instructorName;
	
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDiscription() {
		return courseDiscription;
	}
	public void setCourseDiscription(String courseDiscription) {
		this.courseDiscription = courseDiscription;
	}
	public double getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public List<String> getStudentsCourses() {
		return studentsCourses;
	}
	public void setStudentsCourses(List<String> studentsCourses) {
		this.studentsCourses = studentsCourses;
	}
	private List<String> studentsCourses;

	/**
	 * 
	 */
	public CourseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param courseId
	 * @param courseName
	 * @param courseDiscription
	 * @param coursePrice
	 * @param instructorName
	 * @param studentsCourses
	 */
	public CourseDetails(long courseId, String courseName, String courseDiscription, double coursePrice,
			String instructorName, List<String> studentsCourses) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDiscription = courseDiscription;
		this.coursePrice = coursePrice;
		this.instructorName = instructorName;
		this.studentsCourses = studentsCourses;
	}
	
	
	
	
}
