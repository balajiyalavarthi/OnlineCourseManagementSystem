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

@WebServlet("/adminEditStudent")
public class AdminEditStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Student student = studentService.findById(studentId);
            if (student != null) {
                request.setAttribute("student", student);
                request.getRequestDispatcher("admin_edit_student.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Student not found.");
                response.sendRedirect("admin_dashboard.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("admin_dashboard.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Date enrollmentDate = Date.valueOf(request.getParameter("enrollmentDate"));

        Student student = new Student();
        student.setStudentId(studentId);
        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        student.setEnrollmentDate(enrollmentDate);

        try {
            String result = studentService.update(student);
            HttpSession session = request.getSession();
            
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Student updated successfully!");
            } else {
                session.setAttribute("errorMessage", "Failed to update student: " + result);
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
