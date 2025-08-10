package com.codegnan.web;

import java.io.IOException;

import com.codegnan.model.Instructor;
import com.codegnan.service.InstructorServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/editInstructor")
public class EditInstructorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InstructorServiceImp instructorService = new InstructorServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("instructorId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int instructorId = Integer.parseInt(request.getParameter("id"));
        try {
            Instructor instructor = instructorService.findById(instructorId);
            request.setAttribute("instructor", instructor);
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit_instructor.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            session.setAttribute("errorMessage", "Database error");
            response.sendRedirect("instructorDashboard");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("instructorId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Instructor instructor = new Instructor();
        instructor.setInstructor_id(Integer.parseInt(request.getParameter("id")));
        instructor.setName(request.getParameter("name"));
        instructor.setEmail(request.getParameter("email"));
        instructor.setPassword(request.getParameter("password"));

        try {
            String result = instructorService.update(instructor);
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Profile updated successfully!");
                // Update session email if it was changed
                session.setAttribute("userEmail", instructor.getEmail());
            } else {
                session.setAttribute("errorMessage", result);
            }
            response.sendRedirect("instructorDashboard");
        } catch (ClassNotFoundException e) {
            session.setAttribute("errorMessage", "Database error");
            response.sendRedirect("instructorDashboard");
        }
    }
}