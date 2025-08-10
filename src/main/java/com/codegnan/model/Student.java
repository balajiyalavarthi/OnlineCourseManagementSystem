package com.codegnan.model;

import java.sql.Date;

public class Student {

	private int studentId;
	private String name;
	private String email;
	private String password;
	private Date enrollmentDate;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
	public Student() {
		super();
	}
	
	public Student(int studentId, String name, String email, String password, Date enrollmentDate) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.enrollmentDate = enrollmentDate;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", enrollmentDate=" + enrollmentDate + "]";
	}
	
	
	
	
	
}
