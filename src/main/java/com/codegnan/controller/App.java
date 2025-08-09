package com.codegnan.controller;

import java.sql.Date;

import com.codegnan.model.Instructor;
import com.codegnan.model.Student;
import com.codegnan.service.AdminServiceImp;
import com.codegnan.service.InstructorServiceImp;
import com.codegnan.service.StudentServiceImp;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		AdminServiceImp admin = new AdminServiceImp();
		StudentServiceImp student = new StudentServiceImp();
		InstructorServiceImp instructor = new InstructorServiceImp();
		
//		System.out.println(admin.save(new Admin(1, "admin", "admin@gmail.com", "admin")));
		System.out.println(student.save(new Student(1, "student", "student@gmail.com", "student",  Date.valueOf("2025-08-10"))));
		System.out.println(instructor.save(new Instructor(1, "instructor", "instructor@gmail.com", "instructor")));

	}

}
