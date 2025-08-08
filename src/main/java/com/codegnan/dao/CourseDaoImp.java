package com.codegnan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.CourseDetails;

public class CourseDaoImp implements CourseDao{

	
	
	@Override
	public String addCourse(CourseDetails courseDetails) {
		
		String query = "insert into course_details "
				+ "(courseId, courseName, courseDiscription, coursePrice, instructorName) "
				+ "values"
				+ "(?, ?, ?, ?, ?);";
		String output ="";
		
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)){
			
			
			ps.setInt(1,courseDetails.getCourseId());
			ps.setString(2,courseDetails.getCourseName());
			ps.setString(3, courseDetails.getCourseDiscription());
			ps.setDouble(4, courseDetails.getCoursePrice());
			ps.setString(5, courseDetails.getInstructorName());
			
			int rowsEffected = ps.executeUpdate();
			
			
			if(rowsEffected>=1) {
				output ="success";
			}else {
				output="failure";
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	

	@Override
	public List<CourseDetails> getAllCourses() {
		
		String query = "select * from course_details";
		List<CourseDetails> courses = new ArrayList<>();
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)){
			
			ResultSet rs =  ps.executeQuery();

			if(rs.next()) {
				CourseDetails details = new CourseDetails();
				details.setCourseId(rs.getInt("courseId"));
				details.setCourseName(rs.getString("courseName"));
				details.setCourseDiscription(rs.getString("courseDiscription"));
				details.setCoursePrice(rs.getDouble("coursePrice"));
				details.setInstructorName(rs.getString("instructorName"));
				courses.add(details);
			}
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
	
	

	@Override
	public CourseDetails getByCourseName(String CourseName) {
		CourseDetails details = new CourseDetails();
		String query = "select * from course_details where courseName=?";
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(query) ){
			ps.setString(1, CourseName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				details.setCourseId(rs.getInt("courseId"));
				details.setCourseName(rs.getString("courseName"));
				details.setCourseDiscription(rs.getString("courseDiscription"));
				details.setCoursePrice(rs.getDouble("coursePrice"));
				details.setInstructorName(rs.getString("instructorName"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;
	}

	@Override
	public String updateCourse(CourseDetails courseDetails) {
		
		String query = "update course_details set courseName=?, courseDiscription=?, coursePrice=?, instructorName=? where courseId=?";
		
		String result = "";
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)){
			
			ps.setString(1,courseDetails.getCourseName());
			ps.setString(2, courseDetails.getCourseDiscription());
			ps.setDouble(3,courseDetails.getCoursePrice());
			ps.setString(4, courseDetails.getInstructorName());
			ps.setInt(5,courseDetails.getCourseId());
			
			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated >= 1) {
				result += "success";
			} else {
				result += "failure";
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String deleteCourseByName(String name) {
		
		String result = "";

		String sqlQuery = "delete from course_details" + "where courseName = (?)";
		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlQuery)) {

			ps.setString(1, name);
			int rowsDeleted = ps.executeUpdate();

			if (rowsDeleted == 1) {
				result += "success";
			} else {
				result += "failure";
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("course with name " + name + " not found to delete" + e.getMessage());
		}
		return result;

	}

	}


