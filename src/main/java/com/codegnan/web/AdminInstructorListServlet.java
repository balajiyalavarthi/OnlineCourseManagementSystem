// AdminInstructorListServlet.java
package com.codegnan.web;

import java.io.IOException;
import java.util.List;
import com.codegnan.model.Instructor;
import com.codegnan.service.InstructorServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminInstructorList")
public class AdminInstructorListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InstructorServiceImp instructorService = new InstructorServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Instructor> instructors = instructorService.findAll();
            request.setAttribute("instructors", instructors);
            request.getRequestDispatcher("admin_instructor_list.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}
