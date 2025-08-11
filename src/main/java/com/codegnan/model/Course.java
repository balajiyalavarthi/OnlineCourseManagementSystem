package com.codegnan.model;

import java.sql.Date;

public class Course {
	private int courseId;
	private String courseName;
	private String courseDiscription;
	private int instructorId;
	private Date startDate;
	private Date endDate;
	
	public int getInstructorId() {
	    return instructorId;
	}
	public void setInstructorId(int instructorId) {
	    this.instructorId = instructorId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
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
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId, String courseName, String courseDiscription, int instructorId, Date startDate,
			Date endDate) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDiscription = courseDiscription;
		this.instructorId = instructorId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDiscription="
				+ courseDiscription + ", instructorId=" + instructorId + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	
}
