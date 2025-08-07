package com.codegnan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.StudentsDetails;

public class StudentDaoImp implements StudentDao {

	@Override
	public String addStudent(StudentsDetails studentsDetails) {

		return null;
	}

	@Override
	public List<StudentsDetails> getAllStudents() {
		
		
		List<StudentsDetails> students = new ArrayList<>();
		
//		StudentsDetails student = new StudentsDetails();
		
		String sqlquery = "select* from student_details";
		
		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlquery)){
			
			System.out.println("studentId/studentName/studentEmail/studentCourses");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				students.add(new StudentsDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));	
			}else {
				
			}
			
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		
		
		return students;
	}

	@Override
	public StudentsDetails getByStudentName(String studentName) {

		return null;
	}

	@Override
	public String updateStudent(StudentsDetails studentDetails) {

		return null;
	}

	@Override
	public String deleteStudentByName(String name) {

		return null;
	}

}
