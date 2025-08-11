package com.codegnan.web;

import com.codegnan.model.Course;
import com.codegnan.service.CourseServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CourseServiceImp courseService = new CourseServiceImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get session and instructorId
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("instructorId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int instructorId = (Integer) session.getAttribute("instructorId");

        // Get form data
        String courseName = request.getParameter("courseName");
        String description = request.getParameter("description");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        // Validate date inputs (basic check)
        if (courseName == null || description == null || startDateStr == null || endDateStr == null ||
            courseName.isEmpty() || description.isEmpty() || startDateStr.isEmpty() || endDateStr.isEmpty()) {
            session.setAttribute("errorMessage", "All fields are required.");
            response.sendRedirect("add_course.jsp");
            return;
        }

        try {
            Date startDate = Date.valueOf(startDateStr);
            Date endDate = Date.valueOf(endDateStr);

            if (endDate.before(startDate)) {
                session.setAttribute("errorMessage", "End date cannot be before start date.");
                response.sendRedirect("add_course.jsp");
                return;
            }

            // Create Course object
            Course course = new Course();
            course.setCourseName(courseName);
            course.setCourseDiscription(description);
            course.setStartDate(startDate);
            course.setEndDate(endDate);
            course.setInstructorId(instructorId);

            // Save course using service
            String result = courseService.save(course);

            if ("success".equalsIgnoreCase(result)) {
                session.setAttribute("successMessage", "Course added successfully.");
                response.sendRedirect("instructorCourses"); // or instructor_dashboard.jsp
            } else {
                session.setAttribute("errorMessage", "Failed to add course: " + result);
                response.sendRedirect("add_course.jsp");
            }

        } catch (IllegalArgumentException e) {
            session.setAttribute("errorMessage", "Invalid date format.");
            response.sendRedirect("add_course.jsp");
        } catch (ClassNotFoundException e) {
            session.setAttribute("errorMessage", "Internal error: " + e.getMessage());
            response.sendRedirect("add_course.jsp");
        }
    }
}
