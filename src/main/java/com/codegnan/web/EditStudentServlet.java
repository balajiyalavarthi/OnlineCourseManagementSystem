package com.codegnan.web;

import com.codegnan.model.Student;
import com.codegnan.service.StudentServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editstudent")
public class EditStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idStr = request.getParameter("id");
            if (idStr == null) {
                response.sendRedirect("student_dashboard.jsp");
                return;
            }
            int id = Integer.parseInt(idStr);
            Student student = studentService.findById(id);
            if (student == null) {
                request.setAttribute("error", "Student not found with ID: " + id);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }
            request.setAttribute("student", student);
            request.getRequestDispatcher("edit_student.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error loading student details: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String enrollmentDateStr = request.getParameter("enrollmentDate");

            java.sql.Date enrollmentDate = java.sql.Date.valueOf(enrollmentDateStr);

            Student student = new Student();
            student.setStudentId(id);
            student.setName(name);
            student.setEmail(email);
            student.setPassword(password);
            student.setEnrollmentDate(enrollmentDate);

            studentService.update(student);

            // Redirect to dashboard or list to show changes
            response.sendRedirect("student_dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error updating student: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
