package com.codegnan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.Instructor;

public class InstructorDaoImp implements InstructorDao {

    @Override
    public String addInstructor(Instructor instructor) throws ClassNotFoundException {
    	
        String sql = "INSERT INTO instructor (name, email, password) VALUES (?, ?, ?)";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, instructor.getName());
            ps.setString(2, instructor.getEmail());
            ps.setString(3, instructor.getPassword());

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
    public List<Instructor> getAllInstructors() throws ClassNotFoundException {
    	
        String sql = "SELECT * FROM instructor";
        List<Instructor> instructors = new ArrayList<>();

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Instructor i = new Instructor();
                
                i.setInstructor_id(rs.getInt("instructor_id"));
                i.setName(rs.getString("name"));
                i.setEmail(rs.getString("email"));
                i.setPassword(rs.getString("password"));
                
                instructors.add(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructors;
    }

    @Override
    public Instructor getByInstructorId(int id) throws ClassNotFoundException {
        String sql = "SELECT * FROM instructor WHERE instructor_id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Instructor i = new Instructor();
                    i.setInstructor_id(rs.getInt("instructor_id"));
                    i.setName(rs.getString("name"));
                    i.setEmail(rs.getString("email"));
                    i.setPassword(rs.getString("password"));
                    return i;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String updateByInstructorId(Instructor instructor) throws ClassNotFoundException {
        String sql = "UPDATE instructor SET name = ?, email = ?, password = ? WHERE instructor_id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, instructor.getName());
            ps.setString(2, instructor.getEmail());
            ps.setString(3, instructor.getPassword());
            ps.setInt(4, instructor.getInstructor_id());

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
    public String deleteByInstructorId(int id) throws ClassNotFoundException {
    	
        String sql = "DELETE FROM instructor WHERE instructor_id = ?";
        
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
