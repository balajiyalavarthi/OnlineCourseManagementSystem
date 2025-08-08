package com.codegnan.web;

import java.io.IOException;
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
import jakarta.servlet.http.HttpSession;

@WebServlet("/instructorauth")
public class InstructorAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String originalPassword = "";

		String instructorEmail = request.getParameter("instructorEmail");
		String instructorPassword = request.getParameter("instructorPassword");

		String sqlQuery = "select * from InstructorAuthentication where instructorEmail = ?";

		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlQuery)) {
			ps.setString(1, instructorEmail);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					originalPassword = rs.getString("instructorPassword");

					if (instructorPassword.equals(originalPassword)) {
						HttpSession session = request.getSession();
						session.setAttribute("instructorEmail", instructorEmail);
						response.sendRedirect("instructor_dashboard.jsp");
					} else {
						request.setAttribute("error", "Invalid instructor credentials.");
						RequestDispatcher dispatcher = request.getRequestDispatcher("instructor_login.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("error", "instructor not found.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("instructor_login.jsp");
					dispatcher.forward(request, response);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
