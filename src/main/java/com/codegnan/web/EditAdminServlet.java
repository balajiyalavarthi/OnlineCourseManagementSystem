package com.codegnan.web;

import java.io.IOException;
import com.codegnan.model.Admin;
import com.codegnan.service.AdminServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/editAdmin")
public class EditAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminServiceImp adminService = new AdminServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int adminId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Admin admin = adminService.findById(adminId);
            if (admin != null) {
                request.setAttribute("admin", admin);
                request.getRequestDispatcher("edit_admin.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Admin not found.");
                response.sendRedirect("admin_dashboard.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("admin_dashboard.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int adminId = Integer.parseInt(request.getParameter("adminId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);

        try {
            String result = adminService.update(admin);
            HttpSession session = request.getSession();
            
            if ("success".equals(result)) {
                session.setAttribute("successMessage", "Admin updated successfully!");
                // Update session email if current admin updated their own profile
                Integer currentAdminId = (Integer) session.getAttribute("adminId");
                if (currentAdminId != null && currentAdminId == adminId) {
                    session.setAttribute("userEmail", email);
                }
            } else {
                session.setAttribute("errorMessage", "Failed to update admin: " + result);
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
