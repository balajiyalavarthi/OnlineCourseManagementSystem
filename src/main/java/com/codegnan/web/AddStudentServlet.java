package com.codegnan.web;

import java.io.IOException;
import java.sql.Date;

import com.codegnan.model.Student;
import com.codegnan.service.StudentServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String enrollmentDate = request.getParameter("enrollmentDate");
        
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        String enrollmentDateStr = request.getParameter("enrollmentDate");
        Date newenrollmentDate = Date.valueOf(enrollmentDateStr); // yyyy-MM-dd format
        student.setEnrollmentDate(newenrollmentDate);


        try {
            String result = studentService.save(student);
            request.setAttribute("message", result);
            response.sendRedirect("listStudents");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Unable to save student.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
