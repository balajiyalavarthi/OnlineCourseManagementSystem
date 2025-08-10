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
		    List<Course> courses = new ArrayList<>();
		    String sql = "SELECT c.course_id, c.title as courseName, c.description as courseDiscription, " +
		                 "i.name as instructorName, c.start_date, c.end_date " +
		                 "FROM course c JOIN instructor i ON c.instructor_id = i.instructor_id";
		    
		    try (Connection connection = DbConnection.getConnection();
		         PreparedStatement ps = connection.prepareStatement(sql);
		         ResultSet rs = ps.executeQuery()) {
		        
		        while (rs.next()) {
		            Course course = new Course();
		            course.setCourseId(rs.getInt("course_id"));
		            course.setCourseName(rs.getString("courseName"));
		            course.setCourseDiscription(rs.getString("courseDiscription"));
		            course.setInstructorName(rs.getString("instructorName"));
		            course.setStartDate(rs.getDate("start_date"));
		            course.setEndDate(rs.getDate("end_date"));
		            courses.add(course);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return courses;
		}


	@Override
	public Course getByCourseId(int courseId) throws ClassNotFoundException {
	    String sql = "SELECT c.course_id, c.title as courseName, c.description as courseDiscription, "
	               + "i.name as instructorName, c.start_date, c.end_date "
	               + "FROM course c JOIN instructor i ON c.instructor_id = i.instructor_id "
	               + "WHERE c.course_id = ?";
	    
	    try (Connection conn = DbConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, courseId);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                Course c = new Course();
	                
	                c.setCourseId(rs.getInt("course_id"));
	                c.setCourseName(rs.getString("courseName"));
	                c.setCourseDiscription(rs.getString("courseDiscription"));
	                c.setInstructorName(rs.getString("instructorName"));
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
	
	public List<Course> findCoursesByInstructor(int instructorId) throws ClassNotFoundException {
	    List<Course> courses = new ArrayList<>();
	    String sql = "SELECT * FROM course WHERE instructor_id = ?";
	    
	    try (Connection conn = DbConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setInt(1, instructorId);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Course course = new Course();
	                course.setCourseId(rs.getInt("course_id"));
	                course.setCourseName(rs.getString("title"));
	                course.setCourseDiscription(rs.getString("description"));
	                course.setStartDate(rs.getDate("start_date"));
	                course.setEndDate(rs.getDate("end_date"));
	                courses.add(course);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return courses;
	}
	

}
