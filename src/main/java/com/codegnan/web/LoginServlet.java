package com.codegnan.web;

import java.io.IOException;
import java.sql.*;

import com.codegnan.DbConnection.DbConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Queries for each role
        String adminSQL = "SELECT password FROM admin WHERE email = ?";
        String instructorSQL = "SELECT password FROM instructor WHERE email = ?";
        String studentSQL = "SELECT password FROM student WHERE email = ?";

        try (Connection conn = DbConnection.getConnection()) {

            // Check Admin
            try (PreparedStatement ps = conn.prepareStatement(adminSQL)) {
                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && password.equals(rs.getString("password"))) {
                        setSessionAndRedirect(request, response, email, "ADMIN", "admin_dashboard.jsp");
                        return;
                    }
                }
            }

            // Check Instructor
            try (PreparedStatement ps = conn.prepareStatement(instructorSQL)) {
                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && password.equals(rs.getString("password"))) {
                        setSessionAndRedirect(request, response, email, "INSTRUCTOR", "instructor_dashboard.jsp");
                        return;
                    }
                }
            }

            // Check Student
            try (PreparedStatement ps = conn.prepareStatement(studentSQL)) {
                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && password.equals(rs.getString("password"))) {
                        setSessionAndRedirect(request, response, email, "STUDENT", "student_dashboard.jsp");
                        return;
                    }
                }
            }

            // If none matched
            request.setAttribute("error", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Internal server error. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Helper method to set session and redirect
    private void setSessionAndRedirect(HttpServletRequest request, HttpServletResponse response,
                                        String email, String role, String dashboard)
            throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("userEmail", email);
        session.setAttribute("role", role);
        response.sendRedirect(dashboard);
    }
}
