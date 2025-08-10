package com.codegnan.web;

import java.io.IOException;
import java.sql.Date;

import com.codegnan.model.Course;
import com.codegnan.service.CourseServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseServiceImp courseService = new CourseServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("instructorId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Course course = new Course();
        course.setCourseName(request.getParameter("courseName"));
        course.setCourseDiscription(request.getParameter("description"));
        course.setCoursePrice(Double.parseDouble(request.getParameter("price")));
        course.setInstructorName((String) session.getAttribute("userEmail"));
        course.setStartDate(Date.valueOf(request.getParameter("startDate")));
        course.setEndDate(Date.valueOf(request.getParameter("endDate")));

        try {
            String result = courseService.save(course);
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Course added successfully!");
            } else {
                session.setAttribute("errorMessage", result);
            }
            response.sendRedirect("instructorCourses");
        } catch (ClassNotFoundException e) {
            session.setAttribute("errorMessage", "Database error");
            response.sendRedirect("instructorCourses");
        }
    }
}