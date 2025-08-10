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

@WebServlet("/adminEditInstructor")
public class AdminEditInstructorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InstructorServiceImp instructorService = new InstructorServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int instructorId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Instructor instructor = instructorService.findById(instructorId);
            if (instructor != null) {
                request.setAttribute("instructor", instructor);
                request.getRequestDispatcher("admin_edit_instructor.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Instructor not found.");
                response.sendRedirect("admin_dashboard.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("admin_dashboard.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Instructor instructor = new Instructor();
        instructor.setInstructor_id(instructorId);
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setPassword(password);

        try {
            String result = instructorService.update(instructor);
            HttpSession session = request.getSession();
            
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Instructor updated successfully!");
            } else {
                session.setAttribute("errorMessage", "Failed to update instructor: " + result);
            }
            
            response.sendRedirect("admin_dashboard.jsp");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Database connection error.");
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}
