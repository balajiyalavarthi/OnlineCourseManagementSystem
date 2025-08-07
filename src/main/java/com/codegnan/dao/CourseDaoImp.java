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
		
		String query = "insert into course_details (?,?,?,?)";
		String output ="";
		
		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)){
			
			ps.setString(1,courseDetails.getCourseName());
			ps.setString(2, courseDetails.getCourseDiscription());
			ps.setDouble(3, courseDetails.getCoursePrice());
			ps.setString(4, courseDetails.getInstructorName());
			
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
		List<CourseDetails> courses = new ArrayList();
;		try(PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)){
			
			ResultSet rs =  ps.executeQuery();

			if(rs.next()) {
				CourseDetails details = new CourseDetails();
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
		
		return null;
	}

	@Override
	public String updateCourse(CourseDetails courseDetails) {
		
		return null;
	}

	@Override
	public String deleteCourseByName(String name) {
		
		return null;
	}

}
