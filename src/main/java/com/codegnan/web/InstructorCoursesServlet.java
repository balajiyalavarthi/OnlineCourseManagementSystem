package com.codegnan.web;

import java.io.IOException;
import java.util.List;

import com.codegnan.model.Course;
import com.codegnan.service.CourseServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/instructorCourses")
public class InstructorCoursesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseServiceImp courseService = new CourseServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("instructorId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int instructorId = (Integer) session.getAttribute("instructorId");
        try {
            List<Course> courses = courseService.findCoursesByInstructor(instructorId);
            request.setAttribute("courses", courses);
            RequestDispatcher dispatcher = request.getRequestDispatcher("instructor_courses.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            session.setAttribute("errorMessage", "Database error");
            response.sendRedirect("instructorDashboard");
        }
    }
}