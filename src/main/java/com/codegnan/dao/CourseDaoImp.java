package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.Course;

public class CourseDaoImp implements CourseDao {

    @Override
    public String addCourse(Course course) throws ClassNotFoundException {
        String sql = "INSERT INTO course (title, description, instructor_id, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCourseDiscription());
            ps.setInt(3, course.getInstructorId());  // instructorId from course object
            ps.setDate(4, course.getStartDate());
            ps.setDate(5, course.getEndDate());

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
        String sql = "SELECT course_id, title, description, instructor_id, start_date, end_date FROM course";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("title"));
                course.setCourseDiscription(rs.getString("description"));
                course.setInstructorId(rs.getInt("instructor_id"));
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
        String sql = "SELECT course_id, title, description, instructor_id, start_date, end_date FROM course WHERE course_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, courseId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Course course = new Course();
                    course.setCourseId(rs.getInt("course_id"));
                    course.setCourseName(rs.getString("title"));
                    course.setCourseDiscription(rs.getString("description"));
                    course.setInstructorId(rs.getInt("instructor_id"));
                    course.setStartDate(rs.getDate("start_date"));
                    course.setEndDate(rs.getDate("end_date"));
                    return course;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String updateByCourseName(Course updatedCourse) throws ClassNotFoundException {
        String sql = "UPDATE course SET description=?, instructor_id=?, start_date=?, end_date=? WHERE title=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, updatedCourse.getCourseDiscription());
            ps.setInt(2, updatedCourse.getInstructorId());
            ps.setDate(3, updatedCourse.getStartDate());
            ps.setDate(4, updatedCourse.getEndDate());
            ps.setString(5, updatedCourse.getCourseName());

            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
    }

    @Override
    public String deleteByCourseName(String courseName) throws ClassNotFoundException {
        String sql = "DELETE FROM course WHERE title=?";

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

    @Override
    public List<Course> findCoursesByInstructor(int instructorId) throws ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT course_id, title, description, instructor_id, start_date, end_date FROM course WHERE instructor_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, instructorId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Course course = new Course();
                    course.setCourseId(rs.getInt("course_id"));
                    course.setCourseName(rs.getString("title"));
                    course.setCourseDiscription(rs.getString("description"));
                    course.setInstructorId(rs.getInt("instructor_id"));
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
