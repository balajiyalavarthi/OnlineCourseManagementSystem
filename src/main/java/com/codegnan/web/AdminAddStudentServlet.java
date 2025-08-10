 
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
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminAddStudent")
public class AdminAddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Date enrollmentDate = Date.valueOf(request.getParameter("enrollmentDate"));

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        student.setEnrollmentDate(enrollmentDate);

        try {
            String result = studentService.save(student);
            HttpSession session = request.getSession();
            
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Student added successfully!");
            } else {
                session.setAttribute("errorMessage", "Failed to add student: " + result);
            }
            
            response.sendRedirect("admin_dashboard.jsp");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Database connection error.");
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}

