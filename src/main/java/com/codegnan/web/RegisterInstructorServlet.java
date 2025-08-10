package com.codegnan.web;



import java.io.IOException;

import com.codegnan.model.Instructor;
import com.codegnan.service.InstructorServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerinstructor")
public class RegisterInstructorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InstructorServiceImp instructorService = new InstructorServiceImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        

        try {
            

            Instructor instructor = new Instructor();
            instructor.setName(name);
            instructor.setEmail(email);
            instructor.setPassword(password);
            

            String result = instructorService.save(instructor);

            // After successful registration, redirect to login page
            response.sendRedirect("login.jsp?message=Registration successful! Please login.");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Registration failed: " + e.getMessage());
            request.getRequestDispatcher("register_instructor.jsp").forward(request, response);
        }
    }
}
