package com.codegnan.web;

import java.io.IOException;
import com.codegnan.model.Course;
import com.codegnan.service.CourseServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminFindCourse")
public class AdminFindCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseServiceImp courseService = new CourseServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        
        try {
            Course course = courseService.findById(courseId);
            HttpSession session = request.getSession();
            
            if (course != null) {
                request.setAttribute("foundCourse", course);
                request.getRequestDispatcher("admin_course_search.jsp").forward(request, response);
            } else {
                session.setAttribute("errorMessage", "Course not found with ID: " + courseId);
                response.sendRedirect("admin_course_search.jsp");
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Database connection error.");
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}