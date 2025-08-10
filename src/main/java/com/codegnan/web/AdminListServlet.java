package com.codegnan.web;

import java.io.IOException;
import java.util.List;
import com.codegnan.model.Admin;
import com.codegnan.service.AdminServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminList")
public class AdminListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminServiceImp adminService = new AdminServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Admin> admins = adminService.findAll();
            request.setAttribute("admins", admins);
            request.getRequestDispatcher("admin_list.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}