package com.codegnan.web;

import java.io.IOException;
import com.codegnan.service.InstructorServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminDeleteInstructor")
public class AdminDeleteInstructorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InstructorServiceImp instructorService = new InstructorServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int instructorId = Integer.parseInt(request.getParameter("id"));
        
        try {
            String result = instructorService.deleted(instructorId);
            HttpSession session = request.getSession();
            
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Instructor deleted successfully!");
            } else {
                session.setAttribute("errorMessage", "Failed to delete instructor: " + result);
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
