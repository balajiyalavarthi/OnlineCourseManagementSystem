package com.codegnan.web;

import java.io.IOException;
import java.util.List;
import com.codegnan.model.Student;
import com.codegnan.service.StudentServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminStudentList")
public class AdminStudentListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> students = studentService.findAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("admin_student_list.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}
