package com.codegnan.web;

import java.io.IOException;
import java.sql.Date;


import com.codegnan.model.Enrollment;
import com.codegnan.service.EnrollmentServiceImp;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/enrollCourse")
public class EnrollCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EnrollmentServiceImp enrollmentService = new EnrollmentServiceImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        // Debug output - remove after testing
        System.out.println("Session attributes:");
        if (session != null) {
            java.util.Enumeration<String> attrNames = session.getAttributeNames();
            while (attrNames.hasMoreElements()) {
                String name = attrNames.nextElement();
                System.out.println(name + ": " + session.getAttribute(name));
            }
        }

        // Check if student is logged in
        if (session == null || session.getAttribute("studentId") == null) {
            session.setAttribute("loginMessage", "Please login to enroll in courses");
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int studentId = (Integer) session.getAttribute("studentId");
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            Date enrollmentDate = new Date(System.currentTimeMillis());

            Enrollment enrollment = new Enrollment();
            enrollment.setStudentId(studentId);
            enrollment.setCourseId(courseId);
            enrollment.setEnrollmentDate(enrollmentDate);

            String result = enrollmentService.save(enrollment);
            
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Successfully enrolled in course!");
            } else {
                session.setAttribute("errorMessage", result);
            }
            
            response.sendRedirect("courseList");
            
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Error during enrollment: " + e.getMessage());
            response.sendRedirect("courseList");
        }
    }
}