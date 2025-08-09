package com.codegnan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.Grades;

public class GradesDaoImp implements GradesDao {

    @Override
    public String addGrade(Grades grade) throws ClassNotFoundException {
    	
        String sql = "INSERT INTO grades (submissionId, grade) VALUES (?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, grade.getSubmissionId());
            ps.setString(2, grade.getGrade());

            int rows = ps.executeUpdate();
            return rows > 0 ? "Success" : "failure";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error Adding Grade: " + e.getMessage();
        }
    }

    @Override
    public List<Grades> getAllGrades() throws ClassNotFoundException {
        List<Grades> gradesList = new ArrayList<>();
        String sql = "SELECT * FROM grades";
        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Grades grade = new Grades(
                    rs.getInt("gradeId"),
                    rs.getInt("submissionId"),
                    rs.getString("grade")
                );
                gradesList.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradesList;
    }

    @Override
    public Grades getByGradeId(int id) throws ClassNotFoundException {
        String sql = "SELECT * FROM grades WHERE gradeId = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Grades(
                        rs.getInt("gradeId"),
                        rs.getInt("submissionId"),
                        rs.getString("grade")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Not found
    }

    @Override
    public String updateByGradeId(Grades grade) throws ClassNotFoundException {
    	
        String sql = "UPDATE grades SET submissionId = ?, grade = ? WHERE gradeId = ?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, grade.getSubmissionId());
            ps.setString(2, grade.getGrade());
            ps.setInt(3, grade.getGradeId());

            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error Updating Grade: " + e.getMessage();
        }
    }

    @Override
    public String deleteByGradeId(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM grades WHERE gradeId = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error Deleting Grade: " + e.getMessage();
        }
    }
}
