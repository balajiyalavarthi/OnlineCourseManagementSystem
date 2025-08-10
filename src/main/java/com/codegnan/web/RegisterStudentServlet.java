package com.codegnan.web;

import com.codegnan.model.Student;
import com.codegnan.service.StudentServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/registerstudent")
public class RegisterStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String enrollmentDateStr = request.getParameter("enrollmentDate");

        try {
            Date enrollmentDate = Date.valueOf(enrollmentDateStr);

            Student student = new Student();
            student.setName(name);
            student.setEmail(email);
            student.setPassword(password);
            student.setEnrollmentDate(enrollmentDate);

            String result = studentService.save(student);

            // After successful registration, redirect to login page
            response.sendRedirect("login.jsp?message=Registration successful! Please login.");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Registration failed: " + e.getMessage());
            request.getRequestDispatcher("register_student.jsp").forward(request, response);
        }
    }
}
