package com.codegnan.web;

import com.codegnan.service.StudentServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentServiceImp studentService = new StudentServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            studentService.delete(id);
            response.sendRedirect("listStudents");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Unable to delete student.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
