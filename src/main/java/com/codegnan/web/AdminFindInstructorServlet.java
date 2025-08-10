package com.codegnan.web;

import java.io.IOException;
import com.codegnan.model.Instructor;
import com.codegnan.service.InstructorServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminFindInstructor")
public class AdminFindInstructorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InstructorServiceImp instructorService = new InstructorServiceImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int instructorId = Integer.parseInt(request.getParameter("instructorId"));

		try {
			Instructor instructor = instructorService.findById(instructorId);
			HttpSession session = request.getSession();

			if (instructor != null) {
				request.setAttribute("foundInstructor", instructor);
				request.getRequestDispatcher("admin_instructor_search.jsp").forward(request, response);
			} else {
				session.setAttribute("errorMessage", "Instructor not found with ID: " + instructorId);
				response.sendRedirect("admin_instructor_search.jsp");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			HttpSession session = request.getSession();
			session.setAttribute("errorMessage", "Database connection error.");
			response.sendRedirect("admin_dashboard.jsp");
		}
	}
}