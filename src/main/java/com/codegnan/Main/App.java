package com.codegnan.Main;

import com.codegnan.model.InstructorDetails;
import com.codegnan.service.CourseServiceImp;
import com.codegnan.service.InstructorServiceImp;
import com.codegnan.service.StudentServiceImp;

public class App {

	public static void main(String[] args) {
		
		CourseServiceImp course = new CourseServiceImp();
		InstructorServiceImp instructor = new InstructorServiceImp();
		StudentServiceImp student = new StudentServiceImp();
		
//		System.out.println(course.save(new CourseDetails(1, "java", "java Full Stack course", 40000, "Mallikharjuna")));
//		System.out.println(course.save(new CourseDetails(2, "Python", "python Full Stack course", 40000, "Venu master")));
		
//		System.out.println(student.save(new StudentsDetails(1, "Balaji", "balaji@gmail.com", "JavaFullStack")));
//		System.out.println(student.save(new StudentsDetails(2, "Nagendra", "nagendra@gmail.com", "PythonFullStack")));
		
		System.out.println(instructor.save(new InstructorDetails(1, "Mallikharjuna", "mallikharjuna@gmail.com", "java full Stack")));
		System.out.println(instructor.save(new InstructorDetails(2, "VenuMaster", "venumaster@gmail.com", "python full Stack")));
		
		
	}
}
