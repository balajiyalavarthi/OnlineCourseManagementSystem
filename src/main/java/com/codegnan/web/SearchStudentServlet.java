package com.codegnan.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codegnan.DbConnection.DbConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchstudent")
public class SearchStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentIdStr = request.getParameter("studentId");

        if (studentIdStr == null || studentIdStr.trim().isEmpty()) {
            request.setAttribute("message", "Please enter a Student ID.");
            RequestDispatcher rd = request.getRequestDispatcher("student_search.jsp");
            rd.forward(request, response);
            return;
        }

        try {
            int studentId = Integer.parseInt(studentIdStr);

            Connection conn = DbConnection.getConnection();
            
            String sql = "SELECT student_id AS studentId, name AS studentName, email AS studentEmail, enrollment_date AS enrollmentDate "
            		+ "FROM student WHERE student_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("studentId", rs.getInt("studentId"));
                request.setAttribute("studentName", rs.getString("studentName"));
                request.setAttribute("studentEmail", rs.getString("studentEmail"));
                request.setAttribute("enrollmentDate", rs.getDate("enrollmentDate"));
            } else {
                request.setAttribute("message", "No student found with ID: " + studentId);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid Student ID format.");
        } catch (SQLException e) {
            request.setAttribute("message", "Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("student_search.jsp");
        rd.forward(request, response);
    }
}
