package com.codegnan.web;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.codegnan.model.Assignment;
import com.codegnan.service.AssignmentServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/assignments")
public class AssignmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AssignmentServiceImp assignmentService = new AssignmentServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer instructorId = (Integer) session.getAttribute("instructorId");

        if (instructorId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) action = "viewAll";

        try {
            switch (action) {
                case "edit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Assignment assignment = assignmentService.findById(id);
                    request.setAttribute("assignment", assignment);
                    request.getRequestDispatcher("edit_assignment.jsp").forward(request, response);
                    break;

                case "delete":
                    int deleteId = Integer.parseInt(request.getParameter("id"));
                    String delStatus = assignmentService.delete(deleteId);
                    session.setAttribute(delStatus.equals("success") ? "successMessage" : "errorMessage",
                                         delStatus.equals("success") ? "Assignment deleted!" : "Delete failed!");
                    response.sendRedirect("assignments?action=viewAll");
                    break;

                case "viewAll":
                default:
                    List<Assignment> list = assignmentService.findAll();
                    request.setAttribute("assignmentList", list);
                    request.getRequestDispatcher("view_assignments.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Error: " + e.getMessage());
            response.sendRedirect("instructor_dashboard.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer instructorId = (Integer) session.getAttribute("instructorId");

        if (instructorId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            try {
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                Date dueDate = Date.valueOf(request.getParameter("dueDate"));

                Assignment assignment = new Assignment();
                assignment.setCourseId(courseId);
                assignment.setTitle(title);
                assignment.setDescription(description);
                assignment.setDueDate(dueDate);

                String status = assignmentService.save(assignment);
                session.setAttribute(status.equals("success") ? "successMessage" : "errorMessage",
                                     status.equals("success") ? "Assignment added successfully!" : "Failed to add assignment.");
            } catch (Exception e) {
                session.setAttribute("errorMessage", "Error: " + e.getMessage());
            }
            response.sendRedirect("assignments?action=viewAll");

        } else if ("update".equals(action)) {
            try {
                int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                Date dueDate = Date.valueOf(request.getParameter("dueDate"));

                Assignment assignment = new Assignment(assignmentId, courseId, title, description, dueDate);
                String status = assignmentService.update(assignment);

                session.setAttribute(status.equals("success") ? "successMessage" : "errorMessage",
                                     status.equals("success") ? "Assignment updated successfully!" : "Update failed!");
            } catch (Exception e) {
                session.setAttribute("errorMessage", "Error: " + e.getMessage());
            }
            response.sendRedirect("assignments?action=viewAll");
        }
    }
}
