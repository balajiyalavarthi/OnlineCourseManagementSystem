package com.codegnan.web;

import java.io.IOException;
import java.sql.Date;

import com.codegnan.dao.CourseDaoImp;
import com.codegnan.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminAddCourseServlet")
public class AdminAddCourseEnhancedServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CourseDaoImp courseDao = new CourseDaoImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // 1. Get form parameters
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            int instructorId = Integer.parseInt(request.getParameter("instructor_id"));
            Date startDate = Date.valueOf(request.getParameter("start_date"));
            Date endDate = Date.valueOf(request.getParameter("end_date"));

            // 2. Create Course object
            Course course = new Course();
            course.setCourseName(title);
            course.setCourseDiscription(description);
            course.setInstructorId(instructorId);
            course.setStartDate(startDate);
            course.setEndDate(endDate);

            // 3. Insert course into DB
            String result = courseDao.addCourse(course);

            // 4. Redirect with message
            if ("success".equals(result)) {
                request.setAttribute("message", "Course added successfully!");
            } else {
                request.setAttribute("message", "Failed to add course. " + result);
            }
            
            request.getRequestDispatcher("admin_add_course_enhanced.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Error: " + e.getMessage());
            request.getRequestDispatcher("admin_add_course.jsp").forward(request, response);
        }
    }
}
