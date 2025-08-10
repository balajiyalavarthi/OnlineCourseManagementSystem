package com.codegnan.web;

import java.io.IOException;
import java.util.List;

import com.codegnan.model.Assignment;
import com.codegnan.service.AssignmentServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/studentAssignments")
public class StudentAssignmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AssignmentServiceImp assignmentService = new AssignmentServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer studentId = (Integer) session.getAttribute("studentId");

        if (studentId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            List<Assignment> list = assignmentService.findByStudentId(studentId);
            request.setAttribute("assignmentList", list);
            request.getRequestDispatcher("student_view_assignments.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Error loading assignments");
            response.sendRedirect("student_dashboard.jsp");
        }
    }
}
