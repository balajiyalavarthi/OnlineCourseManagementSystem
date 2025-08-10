package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.codegnan.model.Enrollment;
import com.codegnan.DbConnection.DbConnection; // adjust import to your DB utility

public class EnrollmentDaoImp implements EnrollmentDao {

    @Override
    public String addEnrollment(Enrollment enrollment) throws ClassNotFoundException {
        String sql = "INSERT INTO enrollment (student_id, course_id, enrollment_date) VALUES (?, ?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, enrollment.getStudentId());
            ps.setInt(2, enrollment.getCourseId());
            ps.setDate(3, enrollment.getEnrollmentDate());

            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "failure";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public List<Enrollment> getAllEnrollment() throws ClassNotFoundException {
        List<Enrollment> list = new ArrayList<>();
        String sql = "SELECT * FROM enrollment";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Enrollment e = new Enrollment(
                        rs.getInt("enrollment_id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDate("enrollment_date")
                );
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Enrollment getByEnrollmentId(int id) throws ClassNotFoundException {
        Enrollment enrollment = null;
        String sql = "SELECT * FROM enrollment WHERE enrollment_id = ?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    enrollment = new Enrollment(
                            rs.getInt("enrollment_id"),
                            rs.getInt("student_id"),
                            rs.getInt("course_id"),
                            rs.getDate("enrollment_date")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollment;
    }

    @Override
    public String updateByEnrollmentId(Enrollment enrollment) throws ClassNotFoundException {
        String sql = "UPDATE enrollment SET student_id=?, course_id=?, enrollment_date=? WHERE enrollment_id=?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, enrollment.getStudentId());
            ps.setInt(2, enrollment.getCourseId());
            ps.setDate(3, enrollment.getEnrollmentDate());
            ps.setInt(4, enrollment.getEnrollmentId());

            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String deleteByEnrollmentId(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM enrollment WHERE enrollment_id=?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    
    public boolean isAlreadyEnrolled(int studentId, int courseId) throws ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM enrollment WHERE student_id = ? AND course_id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
