package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.Course;

public class CourseDaoImp implements CourseDao{

	
	
	@Override
	public String addCourse(Course course) throws ClassNotFoundException {
		
		String sql = "INSERT INTO course (course_name, course_discription, course_price, instructor_name, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps =DbConnection.getConnection().prepareStatement(sql)) {
        	
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCourseDiscription());
            ps.setDouble(3, course.getCoursePrice());
            ps.setString(4, course.getInstructorName());
            ps.setDate(5, course.getStartDate());
            ps.setDate(6, course.getEndDate());

            int rows = ps.executeUpdate();
            
            return rows > 0 ? "success" : "failure";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
	}

	@Override
	public List<Course> getAllCourses() throws ClassNotFoundException {
		
		String sql = "SELECT * FROM course";
        List<Course> courses = new ArrayList<>();

        try (PreparedStatement ps =DbConnection.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	
                Course c = new Course();
                
                c.setCourseId(rs.getInt("course_id"));
                c.setCourseName(rs.getString("course_name"));
                c.setCourseDiscription(rs.getString("course_discription"));
                c.setCoursePrice(rs.getDouble("course_price"));
                c.setInstructorName(rs.getString("instructor_name"));
                c.setStartDate(rs.getDate("start_date"));
                c.setEndDate(rs.getDate("end_date"));
                
                courses.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
	}

	
	@Override
	public Course getByCourseName(String courseName) throws ClassNotFoundException {
		
		 String sql = "SELECT * FROM course WHERE course_name = ?";
	        try (Connection conn = DbConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setString(1, courseName);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    Course c = new Course();
	                    
	                    c.setCourseId(rs.getInt("course_id"));
	                    c.setCourseName(rs.getString("course_name"));
	                    c.setCourseDiscription(rs.getString("course_discription"));
	                    c.setCoursePrice(rs.getDouble("course_price"));
	                    c.setInstructorName(rs.getString("instructor_name"));
	                    c.setStartDate(rs.getDate("start_date"));
	                    c.setEndDate(rs.getDate("end_date"));
	                    
	                    return c;
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

	
	
	
	@Override
	public String updateByCourseName(Course updatedCourse) throws ClassNotFoundException {
		
		 String sql = "UPDATE course SET course_discription=?, course_price=?, instructor_name=?, start_date=?, end_date=? WHERE course_name=?";
		 
	        try (Connection conn = DbConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setString(1, updatedCourse.getCourseDiscription());
	            ps.setDouble(2, updatedCourse.getCoursePrice());
	            ps.setString(3, updatedCourse.getInstructorName());
	            ps.setDate(4, updatedCourse.getStartDate());
	            ps.setDate(5, updatedCourse.getEndDate());
	            ps.setString(6, updatedCourse.getCourseName());

	            int rows = ps.executeUpdate();
	            return rows > 0 ? "success" : "notFound";

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return "Database error: " + e.getMessage();
	        }
	}

	
	
	
	@Override
	public String deleteByCourseName(String courseName) throws ClassNotFoundException {
		
		String sql = "DELETE FROM course WHERE course_name=?";
		
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, courseName);
            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
	}
	

}
