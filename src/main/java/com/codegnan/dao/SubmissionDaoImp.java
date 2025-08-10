package com.codegnan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.Submission;

public class SubmissionDaoImp implements SubmissionDao {

    @Override
    public String addSubmission(Submission submission) throws ClassNotFoundException {
        String sql = "INSERT INTO submission (assignment_id, student_id, file_path, submitted_on) VALUES (?, ?, ?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, submission.getAssignmentId());
            ps.setInt(2, submission.getStudentId());
            ps.setString(3, submission.getFilePath());
            ps.setDate(4, submission.getSubmittedOn());

            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "failure";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public List<Submission> getAllSubmission() throws ClassNotFoundException {
        List<Submission> list = new ArrayList<>();
        String sql = "SELECT * FROM submission";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Submission sub = new Submission();
                sub.setSubmissionId(rs.getInt("submission_id"));
                sub.setAssignmentId(rs.getInt("assignment_id"));
                sub.setStudentId(rs.getInt("student_id"));
                sub.setFilePath(rs.getString("file_path"));
                sub.setSubmittedOn(rs.getDate("submitted_on"));
                list.add(sub);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Submission getBySubmissionId(int id) throws ClassNotFoundException {
        Submission sub = null;
        String sql = "SELECT * FROM submission WHERE submission_id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sub = new Submission();
                    sub.setSubmissionId(rs.getInt("submission_id"));
                    sub.setAssignmentId(rs.getInt("assignment_id"));
                    sub.setStudentId(rs.getInt("student_id"));
                    sub.setFilePath(rs.getString("file_path"));
                    sub.setSubmittedOn(rs.getDate("submitted_on"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sub;
    }

    @Override
    public String updateBySubmissionId(Submission submission) throws ClassNotFoundException {
        String sql = "UPDATE submission SET assignment_id = ?, student_id = ?, file_path = ?, submitted_on = ? WHERE submission_id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, submission.getAssignmentId());
            ps.setInt(2, submission.getStudentId());
            ps.setString(3, submission.getFilePath());
            ps.setDate(4, submission.getSubmittedOn());
            ps.setInt(5, submission.getSubmissionId());

            int rows = ps.executeUpdate();
            return rows > 0 ? "success" : "notFound";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String deleteBySubmissionId(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM submission WHERE submission_id = ?";
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
    
    public List<Submission> findByStudentId(int studentId) throws ClassNotFoundException {
        List<Submission> submissions = new ArrayList<>();
        String sql = "SELECT s.submission_id, s.assignment_id, s.student_id, s.file_path, s.submitted_on, a.title " +
                     "FROM submission s " +
                     "JOIN assignment a ON s.assignment_id = a.assignment_id " +
                     "WHERE s.student_id = ? " +
                     "ORDER BY s.submitted_on DESC";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Submission submission = new Submission();
                    submission.setSubmissionId(rs.getInt("submission_id"));
                    submission.setAssignmentId(rs.getInt("assignment_id"));
                    submission.setStudentId(rs.getInt("student_id"));
                    submission.setFilePath(rs.getString("file_path"));
                    submission.setSubmittedOn(rs.getDate("submitted_on"));
                    submissions.add(submission);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return submissions;
    }


}
