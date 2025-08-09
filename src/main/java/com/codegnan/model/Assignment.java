package com.codegnan.model;

import java.sql.Date;

public class Assignment {

    private int assignmentId;
    private int courseId;  // FK
    private String title;
    private String description;
    private Date dueDate;
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assignment(int assignmentId, int courseId, String title, String description, Date dueDate) {
		super();
		this.assignmentId = assignmentId;
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}
	public int getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "AssignmentDao [assignmentId=" + assignmentId + ", courseId=" + courseId + ", title=" + title
				+ ", description=" + description + ", dueDate=" + dueDate + "]";
	}
    
    
}
