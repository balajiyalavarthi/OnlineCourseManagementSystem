package com.codegnan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.Student;

public class StudentDaoImp implements StudentDao {

    @Override
    public String addStudent(Student student) throws ClassNotFoundException {
    	
        String sql = "INSERT INTO student (name, email, password, enrollment_date) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPassword());
            ps.setDate(4, student.getEnrollmentDate());

            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "failure";

        } catch (SQLIntegrityConstraintViolationException e) {
            return "Error: Email already exists";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
    }

    @Override
    public List<Student> getAllStudent() throws ClassNotFoundException {
        String sql = "SELECT * FROM student";
        List<Student> students = new ArrayList<>();

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("password"));
                s.setEnrollmentDate(rs.getDate("enrollment_date"));
                
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student getByStudentId(int id) throws ClassNotFoundException {
        String sql = "SELECT * FROM student WHERE student_id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setStudentId(rs.getInt("student_id"));
                    s.setName(rs.getString("name"));
                    s.setEmail(rs.getString("email"));
                    s.setPassword(rs.getString("password"));
                    s.setEnrollmentDate(rs.getDate("enrollment_date"));
                    return s;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Not found
    }

    @Override
    public String updateByStudentId(Student student) throws ClassNotFoundException {
    	
        String sql = "UPDATE student SET name = ?, email = ?, password = ?, enrollment_date = ? WHERE student_id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPassword());
            ps.setDate(4, student.getEnrollmentDate());
            ps.setInt(5, student.getStudentId());

            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLIntegrityConstraintViolationException e) {
            return "Error: Email already exists";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
    }

    @Override
    public String deleteByStudentId(int id) throws ClassNotFoundException {
    	
        String sql = "DELETE FROM student WHERE student_id = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
    }
}
