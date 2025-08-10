package com.codegnan.web;

import java.io.IOException;
import com.codegnan.service.AdminServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteAdmin")
public class DeleteAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminServiceImp adminService = new AdminServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int adminId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Integer currentAdminId = (Integer) session.getAttribute("adminId");

        try {
            String result = adminService.delete(adminId);
            
            if ("success".equals(result)) {
                // If admin deleted their own account, logout
                if (currentAdminId != null && currentAdminId == adminId) {
                    session.invalidate();
                    response.sendRedirect("login.jsp");
                    return;
                } else {
                    session.setAttribute("successMessage", "Admin deleted successfully!");
                }
            } else {
                session.setAttribute("errorMessage", "Failed to delete admin: " + result);
            }
            
            response.sendRedirect("admin_dashboard.jsp");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Database connection error.");
            response.sendRedirect("admin_dashboard.jsp");
        }
    }
}