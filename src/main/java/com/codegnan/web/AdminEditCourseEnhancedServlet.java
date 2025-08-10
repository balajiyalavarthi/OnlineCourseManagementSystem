// AdminEditCourseEnhancedServlet.java
package com.codegnan.web;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import com.codegnan.model.Course;
import com.codegnan.model.Instructor;
import com.codegnan.service.CourseServiceImp;
import com.codegnan.service.InstructorServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminEditCourseEnhanced")
public class AdminEditCourseEnhancedServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseServiceImp courseService = new CourseServiceImp();
    private InstructorServiceImp instructorService = new InstructorServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int courseId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Course course = courseService.findById(courseId);
            List<Instructor> instructors = instructorService.findAll();
            
            if (course != null) {
                request.setAttribute("course", course);
                request.setAttribute("instructors", instructors);
                request.getRequestDispatcher("admin_edit_course_enhanced.jsp").forward(request, response);
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
        
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String courseName = request.getParameter("courseName");
        String courseDescription = request.getParameter("courseDescription");
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));

        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setCourseDiscription(courseDescription);
        course.setInstructorName(String.valueOf(instructorId));
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