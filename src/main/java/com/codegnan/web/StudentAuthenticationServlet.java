package com.codegnan.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codegnan.DbConnection.DbConnection;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/studentauth")
public class StudentAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String originalPassword = "";
		
		
		String studentEmail = request.getParameter("studentEmail");
		String studentPassword = request.getParameter("studentPassword");

		
		String sqlQuery = "select* from studentAuthentication " + "where studentEmail = ?;";

		
		
		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlQuery)) {
			
			ps.setString(1, studentEmail);
			try (ResultSet rs = ps.executeQuery()) {
				
				if (rs.next()) {
					originalPassword = rs.getString("studentPassword");

					if (studentPassword.equals(originalPassword)) {
						HttpSession session = request.getSession();
						session.setAttribute("studentEmail", studentEmail);
						response.sendRedirect("student_dashboard.jsp");
					} else {
						request.setAttribute("error", "Invalid student credentials.");
						RequestDispatcher dispatcher = request.getRequestDispatcher("student_login.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("error", "Student not found.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("student_login.jsp");
					dispatcher.forward(request, response);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
