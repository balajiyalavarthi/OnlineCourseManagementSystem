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

@WebServlet("/courseList")
public class CourseListServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseServiceImp courseService = new CourseServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Course> courses = courseService.findAll();
            request.setAttribute("courses", courses);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student_courses.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}
