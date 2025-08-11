// AdminCourseListServlet.java
package com.codegnan.web;

import java.io.IOException;
import java.util.List;

import com.codegnan.dao.CourseDaoImp;
import com.codegnan.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminCourseList")
public class AdminCourseListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseDaoImp courseService = new CourseDaoImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Course> courses = courseService.getAllCourses();
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("admin_course_list.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}
