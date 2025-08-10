// AdminFindStudentServlet.java
package com.codegnan.web;

import java.io.IOException;
import com.codegnan.model.Student;
import com.codegnan.service.StudentServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminFindStudent")
public class AdminFindStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        
        try {
            Student student = studentService.findById(studentId);
            HttpSession session = request.getSession();
            
            if (student != null) {
                request.setAttribute("foundStudent", student);
                request.getRequestDispatcher("admin_student_search.jsp").forward(request, response);
            } else {
                session.setAttribute("errorMessage", "Student not found with ID: " + studentId);
                response.sendRedirect("admin_student_search.jsp");
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Database connection error.");
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}