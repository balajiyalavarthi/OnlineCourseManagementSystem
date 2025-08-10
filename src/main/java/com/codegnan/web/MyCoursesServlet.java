package com.codegnan.web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.model.Course;
import com.codegnan.model.Enrollment;
import com.codegnan.service.CourseServiceImp;
import com.codegnan.service.EnrollmentServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myCourses")
public class MyCoursesServlet extends HttpServlet {
    private EnrollmentServiceImp enrollmentService = new EnrollmentServiceImp();
    private CourseServiceImp courseService = new CourseServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Integer studentId = (Integer) session.getAttribute("studentId");
        
        if (studentId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            List<Enrollment> enrollments = enrollmentService.findAll();
            List<Course> enrolledCourses = new ArrayList<>();
            
            for (Enrollment e : enrollments) {
                if (e.getStudentId() == studentId) {
                    Course c = courseService.findById(e.getCourseId());
                    if (c != null) {
                        enrolledCourses.add(c);
                    }
                }
            }
            
            request.setAttribute("enrolledCourses", enrolledCourses);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student_enrolled_courses.jsp");
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException e) {
            session.setAttribute("errorMessage", "System error: " + e.getMessage());
            response.sendRedirect("student_dashboard.jsp");
        }
    }
}