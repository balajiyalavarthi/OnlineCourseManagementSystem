package com.codegnan.web;

import java.io.IOException;

import com.codegnan.model.Course;
import com.codegnan.service.CourseServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courseSearch")
public class CourseSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseServiceImp courseService = new CourseServiceImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get course ID from request parameter
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            
            // Find course by ID
            Course course = courseService.findById(courseId);
            
            // Set course attribute and forward to result page
            request.setAttribute("course", course);
            RequestDispatcher dispatcher = request.getRequestDispatcher("course_search_result.jsp");
            dispatcher.forward(request, response);
            
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid course ID format");
            request.getRequestDispatcher("course_search.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException("Database error", e);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests by redirecting to search page
        request.getRequestDispatcher("course_search.jsp").forward(request, response);
    }
}