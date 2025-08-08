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

/**
 * Servlet implementation class AdminAuthenticationServlet
 */
@WebServlet("/adminauth")
public class AdminAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String adminEmail = request.getParameter("AdminEmail");
		String adminPassword = request.getParameter("AdminPassword");

		String sqlQuery = "select* from courseAuthentication " + "where adminEmail = ?;";

try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlQuery)) {
			
			ps.setString(1, adminEmail);
			try (ResultSet rs = ps.executeQuery()) {
				
				if (rs.next()) {
					String originalPassword = rs.getString("adminPassword");

					if (adminPassword.equals(originalPassword)) {
						HttpSession session = request.getSession();
						session.setAttribute("adminEmail", adminEmail);
						response.sendRedirect("admin_dashboard.jsp");
					} else {
						request.setAttribute("error", "Invalid admin credentials.");
						RequestDispatcher dispatcher = request.getRequestDispatcher("admin_login.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("error", "admin not found.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin_login.jsp");
					dispatcher.forward(request, response);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
