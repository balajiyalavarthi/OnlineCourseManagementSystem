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

@WebServlet("/adminEditCourse")
public class AdminEditCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseServiceImp courseService = new CourseServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int courseId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Course course = courseService.findById(courseId);
            if (course != null) {
                request.setAttribute("course", course);
                request.getRequestDispatcher("admin_edit_course.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Course not found.");
                response.sendRedirect("admin_dashboard.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("admin_dashboard.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String courseName = request.getParameter("courseName");
        String courseDescription = request.getParameter("courseDescription");
        double coursePrice = Double.parseDouble(request.getParameter("coursePrice"));
        String instructorName = request.getParameter("instructorName");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));

        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseDiscription(courseDescription);
        course.setCoursePrice(coursePrice);
        course.setInstructorName(instructorName);
        course.setStartDate(startDate);
        course.setEndDate(endDate);

        try {
            String result = courseService.update(course);
            HttpSession session = request.getSession();
            
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Course updated successfully!");
            } else {
                session.setAttribute("errorMessage", "Failed to update course: " + result);
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
