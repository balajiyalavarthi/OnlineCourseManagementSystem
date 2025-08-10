package com.codegnan.web;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.Submission;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/viewSubmissions")
public class ViewAllSubmissionsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer instructorId = (Integer) session.getAttribute("instructorId");

        if (instructorId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<SubmissionInfo> submissions = new ArrayList<>();

        String sql = """
            SELECT s.submission_id, s.assignment_id, s.student_id, st.name AS student_name,
                   s.file_path, s.submitted_on, a.title AS assignment_title, 
                   c.title AS course_name
            FROM submission s
            JOIN assignment a ON s.assignment_id = a.assignment_id
            JOIN course c ON a.course_id = c.course_id
            JOIN student st ON s.student_id = st.student_id
            WHERE c.instructor_id = ?
            ORDER BY s.submitted_on DESC
        """;

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, instructorId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SubmissionInfo info = new SubmissionInfo();
                    info.setSubmissionId(rs.getInt("submission_id"));
                    info.setAssignmentId(rs.getInt("assignment_id"));
                    info.setAssignmentTitle(rs.getString("assignment_title"));
                    info.setStudentId(rs.getInt("student_id"));
                    info.setStudentName(rs.getString("student_name"));
                    info.setCourseName(rs.getString("course_name"));
                    info.setFilePath(rs.getString("file_path"));
                    info.setSubmittedOn(rs.getDate("submitted_on"));
                    submissions.add(info);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Error loading submissions");
            response.sendRedirect("instructor_dashboard.jsp");
            return;
        }

        request.setAttribute("submissions", submissions);
        request.getRequestDispatcher("view_all_submissions.jsp").forward(request, response);
    }

    // Helper class for joined data
    public static class SubmissionInfo {
        private int submissionId;
        private int assignmentId;
        private String assignmentTitle;
        private int studentId;
        private String studentName;
        private String courseName;
        private String filePath;
        private Date submittedOn;

        // Getters & Setters
        public int getSubmissionId() { return submissionId; }
        public void setSubmissionId(int submissionId) { this.submissionId = submissionId; }
        public int getAssignmentId() { return assignmentId; }
        public void setAssignmentId(int assignmentId) { this.assignmentId = assignmentId; }
        public String getAssignmentTitle() { return assignmentTitle; }
        public void setAssignmentTitle(String assignmentTitle) { this.assignmentTitle = assignmentTitle; }
        public int getStudentId() { return studentId; }
        public void setStudentId(int studentId) { this.studentId = studentId; }
        public String getStudentName() { return studentName; }
        public void setStudentName(String studentName) { this.studentName = studentName; }
        public String getCourseName() { return courseName; }
        public void setCourseName(String courseName) { this.courseName = courseName; }
        public String getFilePath() { return filePath; }
        public void setFilePath(String filePath) { this.filePath = filePath; }
        public Date getSubmittedOn() { return submittedOn; }
        public void setSubmittedOn(Date submittedOn) { this.submittedOn = submittedOn; }
    }
}
