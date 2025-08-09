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

        String sql = "SELECT password, role FROM Users WHERE email = ?";

        try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String dbPassword = rs.getString("password");
                    String role = rs.getString("role"); // ROLE IS TAKEN FROM DB

                    if (password.equals(dbPassword)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("userEmail", email);
                        session.setAttribute("role", role);

                        // Role-based redirection
                        switch (role.toUpperCase()) {
                            case "ADMIN":
                                response.sendRedirect("admin_dashboard.jsp");
                                break;
                            case "INSTRUCTOR":
                                response.sendRedirect("instructor_dashboard.jsp");
                                break;
                            case "STUDENT":
                                response.sendRedirect("student_dashboard.jsp");
                                break;
                            default:
                                request.setAttribute("error", "Unknown role assigned to this user.");
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("error", "Invalid password.");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "User not found.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Internal server error. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
