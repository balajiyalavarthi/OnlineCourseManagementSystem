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
		String result ="";
		String insertQuery = "INSERT INTO student_details"
				+ "(studentId, studentName, studentEmail, studentCourses)"
				+ "VALUES"
				+ "(?, ?, ?, ?)";
		
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(insertQuery)){
			
			ps.setInt(1, studentsDetails.getStudentId());
			ps.setString(2, studentsDetails.getStudentName());
			ps.setString(3, studentsDetails.getStudentEmail());
			ps.setString(4, studentsDetails.getStudentsCourses());
			
			int rowsInserted = ps.executeUpdate();
			
			if(rowsInserted >= 1) {
				result += "success";
			}else {
				result += "failure";
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<StudentsDetails> getAllStudents() {

		// created list with studentsDetails class as Generic type.
		List<StudentsDetails> students = new ArrayList<>();
		
		
		//sql query to get all records from the student_details table
		String sqlquery = "select* from student_details";

		
		//Connecting JDBC with database using DbConnection module using try-catch resources
		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlquery)) {
			
			System.out.println("studentId/studentName/studentEmail/studentCourses");
			
			//used resultset to store each record data from the sql query
			ResultSet rs = ps.executeQuery();

			//If record exists goes inside the while loop
			//then each record column data is captured using rs.get() function
			//then stored into the students list
			
			while (rs.next()) {
				students.add(new StudentsDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
		//if any exceptions raised related to sql, catch block displays the sysout message
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Student not found " + e.getMessage());
		}

		//returns all students list
		return students;
	}

	
	@Override
	public StudentsDetails getByStudentId(int studentId) {
		String sqlQuery = "select*"
				+ "from student_details"
				+ "where studentId = (?)";
		
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlQuery)){
			
			ps.setInt(1, studentId);
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				
				return new StudentsDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
			
		}catch(SQLException | ClassNotFoundException e) {
			
			System.out.println("Student not Found"+e.getMessage());	
		}
		
		return null;
	}

	
	@Override
	public String updateStudent(StudentsDetails studentDetails) {
		String result = "";
		
		String updateQuery = "update student_details"
				+ "set studentId = (?), studentName = (?), studentEmail = (?), studentsCourses = (?)"
				+ "where studentId = (?)";
		
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(updateQuery)){
			
			ps.setInt(1, studentDetails.getStudentId());
			ps.setString(2, studentDetails.getStudentName());
			ps.setString(3, studentDetails.getStudentEmail());
			ps.setString(4, studentDetails.getStudentsCourses());
			ps.setInt(5, studentDetails.getStudentId());
			
			int rowsUpdated = ps.executeUpdate();
			
			if(rowsUpdated >= 1) {
				result +="success";
			}else {
				result+="failure";
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteStudentById(int studentId) {
		
		String result = "";
		
		String sqlQuery = "delete from student_details"
				+ "where studentId = (?)";
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlQuery)){
			
			ps.setInt(1, studentId);
			int rowsDeleted = ps.executeUpdate();
			
			if(rowsDeleted == 1) {
				result += "success";
			}else {
				result += "failure";
			}
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("Student with id "+studentId+" not found to delete"+e.getMessage());
		}
		return result;
	}

}
