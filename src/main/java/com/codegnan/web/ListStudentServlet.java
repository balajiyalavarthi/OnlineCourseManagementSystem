package com.codegnan.web;

import com.codegnan.model.Student;
import com.codegnan.service.StudentServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/listStudents")
public class ListStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Student> students = studentService.findAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("students_list.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Unable to fetch students.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
